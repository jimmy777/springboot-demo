package io.abc.springboot.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/8
 */
@ServerEndpoint("/imserver/{userId}")
@Component
public class WebSocketServer {
    static Log log = LogFactory.get(WebSocketServer.class);

    private static int onlineCount = 0;
    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    private Session session;
    private String userId="";

    /**
     * 连接成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        this.userId = userId;

        if (webSocketMap.containsKey(userId)) {
            webSocketMap.remove(userId);
            webSocketMap.put(userId,this);
        } else {
            webSocketMap.put(userId, this);
            addOnlineCount();
        }

        log.info("用户连接："+userId+"，当前在线人数为："+ getOnlineCount());

        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("用户：" + userId + "，网络异常！！！");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if (webSocketMap.containsKey(userId)) {
            webSocketMap.remove(userId);
            subOnlineCount();
        }

        log.info("用户退出："+ userId + "，当前在线人数为：" + getOnlineCount());
    }

    /**
     * 收到消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户消息：" + userId + "，报文：" + message);

        if (StringUtils.isNotBlank(message)) {
            try {
                JSONObject jsonObject = JSON.parseObject(message);
                jsonObject.put("fromUserId", this.userId);

                String toUserId = jsonObject.getString("toUserId");
                if (StringUtils.isNotBlank(toUserId) && webSocketMap.containsKey(toUserId)) {
                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
                } else {
                    log.error("请求的userId：" + toUserId + "不在该服务器上！！！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误：" + this.userId + "，原因：" + error.getMessage());
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static void sendInfo(String message, @PathParam("userId") String userId) throws IOException {
        log.info("发送消息到：" + userId + "，报文：" + message);
        if (StringUtils.isNotBlank(userId) && webSocketMap.containsKey(userId)) {
            webSocketMap.get(userId).sendMessage(message);
        } else {
            log.error("用户："+ userId + "，不在线！！！");
        }
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }


}

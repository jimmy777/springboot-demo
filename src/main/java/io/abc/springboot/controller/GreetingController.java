package io.abc.springboot.controller;

import io.abc.springboot.pojo.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/7
 */
@Controller
public class GreetingController {
    @MessageMapping("/hello") // 将用来接收/app/hello路径发送来的消息,注意/app在config中的被定义了。
    @SendTo("/topic/greetings") // 处理后的消息转发到/topic/greetings路径上
    public Message greeting(Message message) {
        return message;
    }
}

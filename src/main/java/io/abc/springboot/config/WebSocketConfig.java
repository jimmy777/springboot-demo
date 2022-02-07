package io.abc.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Author: Y.Z.Y
 * @Descriptions: 进行websocket配置
 * @Date: Created in 2022/2/7
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 设置消息代理的前缀，注意前端请求/topic/greetings过来的消息此处被broker处理。消息由broker广播给所有websocket连接的客户端。
        registry.enableSimpleBroker("/topic");
        // 这些前缀过滤出需要被注解方法处理的消息，注意与后面的@MessageMapping对应的注解处理，例如：/app/hello
        registry.setApplicationDestinationPrefixes("/app");
    }

    // 客户端通过这里来建立websocket连接的
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").withSockJS();
    }
}

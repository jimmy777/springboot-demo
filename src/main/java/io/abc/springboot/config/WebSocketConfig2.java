package io.abc.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author: Y.Z.Y
 * @Descriptions: websocket配置类
 * @Date: Created in 2022/2/8
 */
@Configuration
public class WebSocketConfig2 {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}

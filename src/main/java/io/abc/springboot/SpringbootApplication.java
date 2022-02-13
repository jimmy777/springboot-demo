package io.abc.springboot;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    // 提供一个消息队列bean，该bean由Activemq提供。
    @Bean
    ActiveMQQueue queue() {
        return new ActiveMQQueue("amq");
    }

}

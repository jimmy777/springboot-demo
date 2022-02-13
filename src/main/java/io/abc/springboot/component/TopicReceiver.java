package io.abc.springboot.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/13
 */
@Component
public class TopicReceiver {

    @RabbitListener(queues = "xiaomi")
    public void handler1(String message) {
        System.out.println("Xiaomi Receiver: " + message);
    }

    @RabbitListener(queues = "huawei")
    public void handler2(String message) {
        System.out.println("Huawei Receiver: " + message);
    }

    @RabbitListener(queues = "iphone")
    public void handler3(String message) {
        System.out.println("Iphone Receiver: " + message);
    }
}

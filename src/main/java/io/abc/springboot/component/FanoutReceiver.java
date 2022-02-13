package io.abc.springboot.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/13
 */
@Component
public class FanoutReceiver {

    @RabbitListener(queues = "queue-one")
    public void handler1(String message) {
        System.out.println("Fanout Receiver: handler1: " + message);
    }

    @RabbitListener(queues = "queue-two")
    public void handler2(String message) {
        System.out.println("Fanout Receiver: handler2: " + message);
    }
}

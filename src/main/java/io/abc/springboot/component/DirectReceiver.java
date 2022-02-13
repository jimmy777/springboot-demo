package io.abc.springboot.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/13
 */
@Component
public class DirectReceiver {

    @RabbitListener(queues = "demo1-queue")
    public void handler1(String msg) {
        System.out.println("DirectReceiver: " + msg);
    }
}

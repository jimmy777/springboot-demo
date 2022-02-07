package io.abc.springboot.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/7
 */
@Service
@Slf4j
public class Consumer1 {
    // 消费kafka的topic
    @KafkaListener(topics = Producer1.TOPIC)
    public void consumer(String msg) {
        log.info("<<<<<------consumer msg:[{}]", msg);
    }

    // 消费kafka的topic是一个表达式
    @KafkaListener(topics = "${kafka.topic}")
    public void consume2(String msg) {
        log.info("<<<<<------consumer2 msg:[{}]", msg);
    }
}

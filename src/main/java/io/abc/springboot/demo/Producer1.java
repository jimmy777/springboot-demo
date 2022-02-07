package io.abc.springboot.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/7
 */
@Service
@Slf4j
public class Producer1 {
    static final String TOPIC = "user";

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        log.info(">>>>>------producer msg: [{}]", msg);
        kafkaTemplate.send(TOPIC, msg);
    }
}

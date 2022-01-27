package io.abc.springboot.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {
    // TODO: 2022/1/26

    @KafkaListener(topics = "test", groupId = "g1")
    public void listConsumerGroup1(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        System.out.println("g1 value: " + value);
        System.out.println("g1 record: " + record);

        ack.acknowledge();
    }
}

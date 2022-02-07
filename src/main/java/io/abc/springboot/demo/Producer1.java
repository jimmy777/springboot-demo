package io.abc.springboot.demo;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/7
 */
@Service
@Slf4j
public class Producer1 {
    // 定义一个topic
    static final String TOPIC = "user";

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    // 异步往topic发送消息
    public void sendMessage(String msg) {
        log.info(">>>>>------producer msg: [{}]", msg);
        kafkaTemplate.send(TOPIC, msg);
    }

    @Value("${kafka.topic}")
    private String topic;

    // 同步往topic发送消息
    public boolean sendMsgSync(String key, String msg) {
        log.info(">>>>>------producer2 msg: [{}]", msg);
        final boolean[] ok = {true};

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, msg);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(record);
        // 回调函数
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(@NonNull Throwable ex) {
                log.error("sent message=[{}] failed!", msg, ex);
                ok[0] = false;
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("sent message=[{}] with offset=[{}] success!", msg, result.getRecordMetadata().offset());
            }
        });

        // 因为是异步发送，所以我们等待，最多10s
        try {
            future.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException|ExecutionException|TimeoutException e) {
            log.error("waiting for kafka send finish failed!", e);
            return false;
        }
        return ok[0];
    }
}

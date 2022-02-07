package io.abc.springboot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * $ curl http://localhost:8080/kafka/publish?msg=hahah
 * @Date: Created in 2022/2/7
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController2 {

    @Resource
    private Producer1 producer1;

    @GetMapping("/publish")
    public String sendMessage(String msg) {
        producer1.sendMessage(msg);
        return "send message: [" + msg + "] success!";
    }
}

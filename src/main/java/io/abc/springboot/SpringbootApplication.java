package io.abc.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SpringbootApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

    public static void main(String[] args) {
        logger.info("============== 项目启动 =============");
        SpringApplication.run(SpringbootApplication.class, args);
        logger.info("============== 项目停止 =============");
    }

}

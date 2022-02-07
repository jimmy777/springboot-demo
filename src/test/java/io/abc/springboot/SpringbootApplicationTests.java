package io.abc.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringbootApplicationTests {

//    private static final Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

    @Test
    void contextLoads() {
        log.info("带参日志测试:{}", "参数111");
    }
}

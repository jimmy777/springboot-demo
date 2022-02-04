package io.abc.springboot;

import io.abc.springboot.config.WebSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    WebSecurityConfig webSecurityConfig;

    @Test
    void contextLoads() {
        System.out.println(webSecurityConfig.passwordEncoder().encode("123"));
    }

}

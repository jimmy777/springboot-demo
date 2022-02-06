package io.abc.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            String encode = encoder.encode("123");
            System.out.println(encode);
    }
}

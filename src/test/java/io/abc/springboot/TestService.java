package io.abc.springboot;

import io.abc.springboot.component.RegBean;
import io.abc.springboot.serivce.RegService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class TestService {
    // TODO: 2022/2/4  

    @Autowired
    RegService regService;

    @Autowired
    RegBean regBean;

    @Test
    public void test1() {
        String admin = regService.reg("admin", "123");
        System.out.println("admin's password is: " + admin);
    }

    @Test
    public void test2() {
        PasswordEncoder passwordEncoder = regBean.passwordEncoder();
        String encode = passwordEncoder.encode("123");
        System.out.println(encode);
    }
}

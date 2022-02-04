package io.abc.springboot.component;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegBean {
    // TODO: 2022/2/4

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}

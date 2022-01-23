package io.abc.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(1)
public class MyCommandLineRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // TODO: 2022/1/23  
        System.out.println("自定义Runner1 >>> " + Arrays.toString(args));
    }
}

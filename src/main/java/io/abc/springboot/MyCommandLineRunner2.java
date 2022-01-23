package io.abc.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(2)
public class MyCommandLineRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // TODO: 2022/1/23  
        System.out.println("自定义Runner2 >>> " + Arrays.toString(args));
    }
}

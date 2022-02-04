package io.abc.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // TODO: 2022/2/4

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}

package io.abc.springboot.controllers;

import io.abc.springboot.beans.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // TODO: 2022/1/23
    @Autowired
    Hello hello;

    @GetMapping("/hello")
    public String hello() {
        return hello.sayHello("Jack");
    }
}

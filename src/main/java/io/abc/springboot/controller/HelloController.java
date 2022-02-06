package io.abc.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/6
 */
@RestController
public class HelloController {
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello, admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello, user";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}

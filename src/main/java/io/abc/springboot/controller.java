package io.abc.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    // TODO: 2022/2/5

    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "this page is: Admin";
    }

    @GetMapping("/db")
    public String getDb() {
        return "this page is: Database";
    }

    @GetMapping("/user")
    public String getUser() {
        return "this page is: User";
    }
}

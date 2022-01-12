package io.abc.springboot.controllers;

import org.springframework.web.bind.annotation.*;

/**
 * 测试 cors 组件
 */
@RestController
@RequestMapping("/book2d")
public class BookController2D {
    @PostMapping("/")
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    public String addBook(String name) {
        return "receive: " + name;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    public String deleteBookById(@PathVariable Long id) {
        return String.valueOf(id);
    }
}

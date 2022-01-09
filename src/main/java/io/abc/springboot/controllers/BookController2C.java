package io.abc.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BookController2C {
    @GetMapping("/book2c")
    public Book3 book3() {
        Book3 book = new Book3();
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setPrice(30f);
        book.setPublicationDate(new Date());

        return book;
    }
}

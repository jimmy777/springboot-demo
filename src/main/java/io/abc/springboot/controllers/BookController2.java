package io.abc.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class BookController2 {
    @GetMapping("book2")
    @ResponseBody
    public Book2 book() {
        Book2 book = new Book2();
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setPrice(30f);
        book.setPublicationDate(new Date());

        return book;
    }
}

package io.abc.springboot.controller;

import io.abc.springboot.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookDao bookDao;

    @GetMapping("/getbook")
    public void getBookById() {
        bookDao.getBookById(1);
        bookDao.getBookById(1);

    }
}

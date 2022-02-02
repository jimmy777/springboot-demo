package io.abc.springboot.controller;

import io.abc.springboot.dao.BookDao;
import io.abc.springboot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookCtroller {
    // TODO: 2022/2/2

    @Autowired
    BookDao bookDao;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/getbook")
    public void getBook() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("Python");
        book1.setAuthor("Tom");
        books.add(book1);

        Book book2 = new Book();
        book2.setId(2);
        book2.setName("Java");
        book2.setAuthor("Tom");
        books.add(book2);

        bookDao.insert(books);

        List<Book> books1 = bookDao.findByAuthorContains("Tom");
        System.out.println(books1);

        Book javabook = bookDao.findByNameEquals("Java");
        System.out.println(javabook);
    }

    @GetMapping("/getbook2")
    public void getBook2() {
        List<Book> allbooks = mongoTemplate.findAll(Book.class);
        System.out.println(allbooks);

        Book book = mongoTemplate.findById(2, Book.class);
        System.out.println(book);
    }
}

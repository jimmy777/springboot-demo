package io.abc.springboot.controllers;

import io.abc.springboot.models.Book;
import io.abc.springboot.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    // TODO: 2022/1/25

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @GetMapping("/bookOps")
    public void bookOps() {
        logger.info("---");

//        Book book3 = new Book();
//        book3.setName("name-a3");
//        book3.setAuthor("author-a3");
//        int i = bookService.addBook(book3);
//        System.out.println("add book >>> " + i);

//        Book book2 = new Book();
//        book2.setId(2);
//        book2.setName("name-aa2");
//        book2.setAuthor("author-aa2");
//        int i2 = bookService.updateBook(book2);
//        System.out.println("updata book >>> " + i2);

//        Book b3 = bookService.getBookById(3);
//        System.out.println("get book >>> " + b3);

        List<Book> allBooks = bookService.getAllBooks();
        System.out.println("get all books >>> " + allBooks);

    }
}

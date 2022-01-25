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
//        Book book1 = new Book();
//        book1.setName("name-a1");
//        book1.setAuthor("author-a1");
//
//        int i = bookService.addBook(book1);
//        System.out.println("add new book >>> " + i);
//
//        Book book2 = new Book();
//        book2.setId(1);
//        book2.setName("name-a1-b1");
//        book2.setAuthor("author-a1-b1");
//        int i2 = bookService.updateBook(book2);
//        System.out.println("update book >>> " + i2);

//        Book book = bookService.getBookById(1);
//        System.out.println("get book >>> " + book);
//

        Thread thread = Thread.currentThread();
        logger.info("------>thread: " + thread.getName());
        List<Book> allBooks = bookService.getAllBooks();
        System.out.println("get all books >>> " + allBooks);

//        int deleteBook = bookService.deleteBook(1);
//        System.out.println("delete book >>> " + deleteBook);

    }
}

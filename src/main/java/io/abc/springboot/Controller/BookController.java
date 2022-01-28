package io.abc.springboot.Controller;

import io.abc.springboot.entity.Book;
import io.abc.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    // TODO: 2022/1/27

    @Autowired
    BookService bookService;

    @GetMapping("/findAll")
    public void findAll() {
        PageRequest pageable = PageRequest.of(2, 3);
        Page<Book> page = bookService.getBookByPage(pageable);
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("查询结果：" + page.getContent());
        System.out.println("当前页数：" + (page.getNumber() + 1));
        System.out.println("当前页记录数：" + page.getNumberOfElements());
        System.out.println("每页记录数：" + page.getSize());
    }

    @GetMapping("/search")
    public void search() {
        List<Book> book1 = bookService.getBookByIdAndAuthor("tom", 2);
        System.out.println("书1：" + book1);

        List<Book> book2 = bookService.getBooksByAuthorStartingWith("t");
        System.out.println("书2：" + book2);

        List<Book> book3 = bookService.getBooksByIdAndName("t", 2);
        System.out.println("书3：" + book3);

        List<Book> book4 = bookService.getBooksByPriceGreaterThan(20F);
        System.out.println("书4：" + book4);

        Book book5 = bookService.getMaxIdBook();
        System.out.println("书5：" + book5);
    }

    @GetMapping("/save")
    public void save() {
        Book book = new Book();
        book.setAuthor("x1");
        book.setName("nothing");
        book.setPrice(33.45F);
        bookService.addBook(book);
    }
}

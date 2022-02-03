package io.abc.springboot;

import io.abc.springboot.dao.BookDao;
import io.abc.springboot.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test1 {

    @Autowired
    BookDao bookDao;

    @Test
    public void test1() {
        bookDao.getBookById(1);
        bookDao.getBookById(1);

        bookDao.deleteBookById(1);
        Book book1 = bookDao.getBookById(1);
        System.out.println("book1 is: " + book1);

        Book book2 = new Book();
        book2.setName("Java");
        book2.setAuthor("tomas");
        book2.setId(1);
        bookDao.updateBookById(book2);
        Book book3 = bookDao.getBookById(1);
        System.out.println("book1 is: " + book3);
    }
}

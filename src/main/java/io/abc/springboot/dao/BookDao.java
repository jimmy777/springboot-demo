package io.abc.springboot.dao;

import io.abc.springboot.domain.Book;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;



@Repository
@CacheConfig(cacheNames = "book_cache")
public class BookDao {
    // TODO: 2022/2/4

    @Cacheable
    public Book getBookById(Integer id) {
        System.out.println("get book by id.");
        Book book = new Book();
        book.setId(1);
        book.setName("Python 2");
        book.setAuthor("tom");
        return book;
    }

    @CacheEvict(key="#id")
    public void deleteBookById(Integer id) {
        System.out.println("delete book by id.");
    }

    @CachePut(key = "#book.id")
    public Book updateBookById(Book book) {
        System.out.println("update book by id.");
        book.setName("Python 3");
        return book;
    }
}

package io.abc.springboot.dao;

import io.abc.springboot.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookDao extends MongoRepository<Book, Integer> {
    // TODO: 2022/2/2

    List<Book> findByAuthorContains(String author);
    Book findByNameEquals(String name);
}

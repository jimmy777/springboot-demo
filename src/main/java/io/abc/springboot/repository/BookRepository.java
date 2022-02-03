package io.abc.springboot.repository;

import io.abc.springboot.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {
    // TODO: 2022/2/3

}

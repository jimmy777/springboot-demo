package io.abc.springboot.repository;

import io.abc.springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path="bs", collectionResourceRel = "bs", itemResourceRel = "b")
public interface BookRepository extends JpaRepository<Book, Integer> {
    // TODO: 2022/2/3

}

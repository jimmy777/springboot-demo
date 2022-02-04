package io.abc.springboot.dao;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "c1")
public class BookDao {
    // TODO: 2022/2/4

    @Cacheable
    public void getBookById(Integer id) {
        System.out.println("get book " + id);
    }
}

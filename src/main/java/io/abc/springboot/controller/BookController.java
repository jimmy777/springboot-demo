package io.abc.springboot.controller;

import io.abc.springboot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    // TODO: 2022/2/2

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getbook")
    public void getBook() {
        ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
        ops1.set("name", "tom");
        String name = ops1.get("name");
        System.out.println(name);

        ValueOperations ops2 = redisTemplate.opsForValue();
        Book book = new Book();
        book.setId(1);
        book.setName("Hello Python");
        book.setAuthor("jack");
        ops2.set("book", book);
        Book book1 = (Book)ops2.get("book");
        System.out.println(book1);
    }
}

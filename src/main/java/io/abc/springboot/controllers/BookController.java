package io.abc.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    // TODO: 2022/1/25

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);


    @GetMapping("/bookOps")
    public void bookOps() {
        logger.info("---");
    }
}

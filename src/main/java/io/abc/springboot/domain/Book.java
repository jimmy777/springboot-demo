package io.abc.springboot.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {
    // TODO: 2022/2/2

    private Integer id;
    private String name;
    private String author;
}

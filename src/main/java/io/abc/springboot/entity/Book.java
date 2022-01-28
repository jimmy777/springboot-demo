package io.abc.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "t_book")
@Data
public class Book {
    // TODO: 2022/1/27

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_name", nullable = false)
    private String name;

    private String author;
    private Float price;

    @Transient
    private String description;
}

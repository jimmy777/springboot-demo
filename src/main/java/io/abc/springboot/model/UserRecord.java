package io.abc.springboot.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRecord {
    // TODO: 2022/1/28

    @Id
    private int id;
    private String name;
    private String email;
}

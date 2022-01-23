package io.abc.springboot.aop.service;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    // TODO: 2022/1/23

    public String getPersonById(Integer id) {
        System.out.println("get person ... " + id);
        return "person";
    }

    public void deletePersonById(Integer id) {
        System.out.println("delete person ... " + id);
    }
}

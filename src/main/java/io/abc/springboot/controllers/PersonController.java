package io.abc.springboot.controllers;

import io.abc.springboot.aop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    // TODO: 2022/1/23

    @Autowired
    PersonService personService;

    @GetMapping("/getPersonById")
    public String getUserById(Integer id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/deletePersonById")
    public void deleteUserById(Integer id) {
        personService.deletePersonById(id);
    }
}

package com.manageaddress.controller;

import com.manageaddress.model.Person;
import com.manageaddress.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/save")
    public boolean addPerson() {
        return true;
    }

    @GetMapping("/get-all")
    public List<Person> findAll() {
        List<Person> allPerson = personService.getAllPerson();
        return allPerson;
    }
}

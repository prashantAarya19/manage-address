package com.manageaddress.controller;

import com.manageaddress.model.Person;
import com.manageaddress.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public ModelAndView getHome() {
        return new ModelAndView("/add_address");
    }

    @GetMapping("/operations")
    public ModelAndView operations() {
        return new ModelAndView("/operations");
    }

    @GetMapping("/get-all")
    public List<Person> findAll() {
        List<Person> allPerson = personService.getAllPerson();
        return allPerson;
    }

    @PostMapping("/add")
    public Boolean addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

}

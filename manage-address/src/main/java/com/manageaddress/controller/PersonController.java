package com.manageaddress.controller;

import com.google.gson.Gson;
import com.manageaddress.model.Person;
import com.manageaddress.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
        return new ModelAndView("/delete_address");
    }

    @GetMapping("/get-all")
    public List<Person> findAll() {
        List<Person> allPerson = personService.getAllPerson();
        return allPerson;
    }

}

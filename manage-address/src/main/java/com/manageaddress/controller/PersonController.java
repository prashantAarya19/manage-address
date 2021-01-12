package com.manageaddress.controller;

import com.manageaddress.ManageAddressUtil;
import com.manageaddress.model.Address;
import com.manageaddress.model.Person;
import com.manageaddress.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    HttpSession session;

    @GetMapping("/")
    public ModelAndView getHome() {
        return new ModelAndView("/operations");
    }

    @GetMapping("/operations")
    public ModelAndView operations() {
        return new ModelAndView("/find_address");
    }

    @GetMapping("/get-all")
    public List<Person> findAll() {
        List<Person> allPerson = personService.getAllPerson();
        return allPerson;
    }

    @PostMapping("/add")
    public Boolean addPerson(@RequestBody Map<String, String> data) {
        return personService.addPerson(ManageAddressUtil.getPerson(data));
    }

    @PostMapping("/update")
    public Boolean updatePerson(@RequestBody Map<String, String> data) {
        Long personId = Optional.ofNullable(session.getAttribute("person_id"))
                .map(Long.class::cast)
                .orElseThrow(() -> new IllegalArgumentException("ID NOT PRESENT"));
        Long addressId = Optional.ofNullable(session.getAttribute("address_id"))
                .map(Long.class::cast)
                .orElseThrow(() -> new IllegalArgumentException("ID NOT PRESENT"));
        Person person = ManageAddressUtil.getPerson(data);
        person.setId(personId);
        person.getAddress().setId(addressId);
        return personService.updatePerson(person);
    }

    @GetMapping("/delete-one")
    public Boolean deleteOnePerson(@RequestParam String attribute, @RequestParam String value) {
        return personService.deletePerson(attribute, value);
    }

    @GetMapping("/find-one")
    public Person findOnePerson(@RequestParam String attribute, @RequestParam String value) {
        Person person = personService.getOnePerson(attribute, value);
        session.setAttribute("person_id", person.getId());
        Address address = person.getAddress();
        session.setAttribute("address_id", address.getId());
        return person;
    }

}

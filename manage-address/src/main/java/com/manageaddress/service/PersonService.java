package com.manageaddress.service;

import com.manageaddress.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {

    boolean addPerson(Person person);

    boolean updatePerson(Person person);

    boolean deletePerson(String attribute, String person);

    Person getOnePerson(String attribute, String value);

    List<Person> getAllPerson();
}

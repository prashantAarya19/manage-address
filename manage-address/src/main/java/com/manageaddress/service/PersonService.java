package com.manageaddress.service;

import com.manageaddress.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {

    public boolean addPerson(Person person);

    public boolean updatePerson(Person person);

    public boolean deletePerson(Person person);

    public Person getOnePerson(Person person);

    public List<Person> getAllPerson();
}

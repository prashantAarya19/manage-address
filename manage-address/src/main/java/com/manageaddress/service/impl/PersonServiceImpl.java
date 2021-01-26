package com.manageaddress.service.impl;

import com.manageaddress.model.Person;
import com.manageaddress.repository.PersonRepository;
import com.manageaddress.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean addPerson(Person person) {
        person.setAddressId(person);
        Person save = personRepository.save(person);
        if (!ObjectUtils.isEmpty(save)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePerson(Person person) {
        person.setAddressId(person);
        try {
            person = personRepository.save(person);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        if (ObjectUtils.isEmpty(person)) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean deletePerson(String attribute, String value) {
        Person person;
        switch (attribute) {
            case "email":
                person = personRepository.findByEmail(value.toLowerCase());
                break;
            default:
                throw new IllegalArgumentException("Either argument not present or invalid!");
        }

        Long personId = person.getId();
        try {
            personRepository.deleteById(personId);
            return true;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Person getOnePerson(String attribute, String value) {
        Person person = null;
        switch (attribute) {
            case "firstName":
                person = personRepository.findByFirstName(value.toLowerCase());
                break;
            case "lastName":
                person = personRepository.findByLastName(value.toLowerCase());
                break;
            default:
                throw new IllegalArgumentException("INVALID_INPUT");
        }
        return person;
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

}

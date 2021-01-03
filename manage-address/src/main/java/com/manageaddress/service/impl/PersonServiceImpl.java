package com.manageaddress.service.impl;

import com.manageaddress.model.Address;
import com.manageaddress.model.Person;
import com.manageaddress.repository.PersonRepository;
import com.manageaddress.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean addPerson(Person person) {
        Address address = person.getAddress();
        address.setPerson(person);
        person.setAddress(address);
        Person save = personRepository.save(person);
        if(!ObjectUtils.isEmpty(save)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean deletePerson(Person person) {
        return false;
    }

    @Override
    public Person getOnePerson(Person person) {
        return null;
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

}

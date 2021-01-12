package com.manageaddress.repository;

import com.manageaddress.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    public Person findByFirstName(String firstName);
    public Person findByLastName(String lastName);
}

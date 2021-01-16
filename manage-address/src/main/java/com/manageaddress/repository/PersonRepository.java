package com.manageaddress.repository;

import com.manageaddress.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select top 1 * from person p inner join address a on a.person_id = p.id where p.first_name = ?", nativeQuery = true)
    Person findByFirstName(String firstName);
    Person findByLastName(String lastName);
}

package com.manageaddress.repository;

import com.manageaddress.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value = "select * from person p inner join address a on a.person_id = p.id where p.email = ?", nativeQuery = true)
    Person findByEmail(String email);

    @Query(value = "delete from person where email = ?", nativeQuery = true)
    Person deleteByEmail(String email);
}

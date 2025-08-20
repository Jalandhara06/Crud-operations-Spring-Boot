package com.jalandhara.crud.repository;

import com.jalandhara.crud.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

    @Query("select p from Person p order by p.id")
    List<Person> sortPersonsById();

    @Query("select p from Person p where p.id = :id")
    Person findPersonById(@Param("id") Long id);

    @Query("select p from Person p where substring(p.name, 1, 1) in :letter")
    List<Person> getPersonByName(@Param("letter") List<String> letter);

    @Modifying
    @Query("update Person p set p.age = ?1 where p.id = ?2")
    void updatePersonAgeById(Integer age, Long id);

}

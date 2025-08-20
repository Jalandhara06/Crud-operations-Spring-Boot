package com.jalandhara.crud.controller;

import com.jalandhara.crud.repository.PersonRepo;
import com.jalandhara.crud.model.Person;
import com.jalandhara.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @PostMapping("/addAll")
    public List<Person> addPersons(@RequestBody List<Person> persons){
        return personService.addPersons(persons);
    }

    @GetMapping("/fetchAll")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    @GetMapping("/fetchById/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedData){
        return personService.updatePerson(id, updatedData);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }

    @GetMapping("/fetchAllBySort")
    public List<Person> fetchAllBySort(){
        return personService.listAllPerson();
    }

    @GetMapping("/getPersonById/{id}")
    public Person getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }

    @GetMapping("/getPersonByName")
    public List<Person> getPersonByName(@RequestParam List<String> letter){
        return personService.getPersonByName(letter);
    }

    @PutMapping("/updatePersonAgeById")
    public ResponseEntity<?> updatePersonAgeById(@RequestParam Integer age, @RequestParam Long id){
        personService.updatePersonAgeById(age,id);
        return ResponseEntity.ok("Updated successfully.");
    }
}





// Sending request and getting response with post operation  at request body - Insert and view
//    @PostMapping("/addPerson")
//    public ResponseEntity<Person> createPerson(@RequestBody Person person){
//        Person response = personRepo.save(person);
//        return ResponseEntity.ok(response);
//    }
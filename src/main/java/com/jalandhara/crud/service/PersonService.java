package com.jalandhara.crud.service;

import com.jalandhara.crud.model.Person;
import com.jalandhara.crud.repository.PersonRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    // Sending request with post operation  at request body - Insert
    public void addPerson(Person person){
        personRepo.save(person);
    }

    // Inserting multiple rows into table with postMapping & requestBody
    public List<Person> addPersons(List<Person> persons){
        personRepo.saveAll(persons);
        return persons;
    }

    //Fetching all person details as list using getMapping - Display all
    public List<Person> getAllPerson(){
        return personRepo.findAll();
    }

    //Displaying specific user detail by id with getMapping, PathVariable, findById - display Particular
    public Person getPerson(Long id){
        return personRepo.findById(id).orElse(null);
    }

    //Updating specific data by id using putMapping, Getter & setter methods along with pathVariable for id & requestBody for entering values - Update 1
    public Person updatePerson(Long id, Person updatedData){
        Person existingData = personRepo.findById(id).orElse(null);
        if(existingData != null){
            existingData.setName(updatedData.getName());
            existingData.setEmail(updatedData.getEmail());
            existingData.setMobileNumber(updatedData.getMobileNumber());
            existingData.setAge(updatedData.getAge());
            personRepo.save(existingData);
        }else {
            return null;
        }
        return existingData;
    }

    // Delete operation is performed by deleteMapping and pathVariable
    public void deletePerson(Long id){
        personRepo.deleteById(id);
    }

    public List<Person> listAllPerson(){
        return personRepo.sortPersonsById();
    }

    public Person getPersonById(Long id){
        return personRepo.findPersonById(id);
    }

    public List<Person> getPersonByName(List<String> letter) {
        return personRepo.getPersonByName(letter);
    }

    @Transactional
    public void updatePersonAgeById(Integer age, Long id) {
        personRepo.updatePersonAgeById(age,id);
    }
}

package com.example.service;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {


    // wstrzykujemy poprzez konstruktor
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> getPeronList() {
        return personRepository.findAll();
    }

    public Optional<Person> getPerson(Long id){
        return personRepository.findById(id);
    }

/*
    public void addPerson(Person person){
        Person newPerson = new Person(
                person.getFirstName(),
                person.getLastName(),
                person.getGitHub(),
                person.getStart());
        personRepository.save(newPerson);
        System.out.println("adding person on id:" + newPerson.getId());
    }*/



}

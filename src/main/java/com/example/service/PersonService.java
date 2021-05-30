package com.example.service;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    //wstrzykujemy poprzez konstruktor
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonList() {
        return personRepository.findAll();
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public void addPerson(Person person) {
        Person newPerson = new Person(
                person.getFirstName(),
                person.getLastName(),
                person.getGithub(),
                person.getStart(),
                person.getJava(),
                person.getBestpractice(),
                person.getTdd(),
                person.getQuestion(),
                person.getHibarnate(),
                person.getHtml(),
                person.getJsp(),
                person.getThymeleaf(),
                person.getGit(),
                person.getCheckbox());
        personRepository.save(newPerson);
        System.out.println("adding new person on id: " + newPerson.getId());
    }

    public void editPerson(Person person, Long id) {
        Person editPerson = new Person(
                id,
                person.getFirstName(),
                person.getLastName(),
                person.getGithub(),
                person.getStart(),
                person.getJava(),
                person.getBestpractice(),
                person.getTdd(),
                person.getQuestion(),
                person.getHibarnate(),
                person.getHtml(),
                person.getJsp(),
                person.getThymeleaf(),
                person.getGit(),
                person.getCheckbox());
        personRepository.save(editPerson);
        System.out.println("adding new person on id: " + editPerson.getId());
    }
}
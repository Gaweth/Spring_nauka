package com.example.contoller;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class PersonList {

    // realizujemy wstrzyknięcie poprzezk onstruktor
    private final PersonRepository personRepository;
    private final PersonService personService;

    public PersonList(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

    // get all persons
    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String getPersonList(Model model) {
        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);
        return "persons/personList";
    }

    // only get view add new person
    @RequestMapping(value = {"/addNewPerson"}, method = RequestMethod.GET)
    public String getAddNewPerson() {
        return "persons/addNewPerson";
    }

    // save person in database
    @RequestMapping(value = {"/addNewPerson"}, method = RequestMethod.POST)
    public RedirectView postAddNewPerson(@ModelAttribute Person newPerson) {
        personRepository.save(newPerson);
        return new RedirectView("/personList");
    }

    // get person for editview
    @RequestMapping(value = {"/editPerson/{id}"}, method = RequestMethod.GET)
    public String getEditPerson(Model model, @PathVariable("id") Long id) {
        Person person = personRepository.findById(id).orElse(null);
        model.addAttribute("person", person);
        return "persons/editPerson";
    }

    // save edit person
    @RequestMapping(value = {"/personList/{id}"}, method = RequestMethod.POST)
    public RedirectView postEditPerson(@ModelAttribute Person newPerson, @PathVariable("id") Long id) {
        personRepository.save(newPerson);
        return new RedirectView("/editPerson/{id}");
    }

}
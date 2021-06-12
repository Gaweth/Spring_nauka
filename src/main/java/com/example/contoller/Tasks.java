package com.example.contoller;

import com.example.model.Person;
import com.example.model.Task;
import com.example.repository.PersonRepository;
import com.example.repository.TasksRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class Tasks {


    private final PersonRepository personRepository;

    private final TasksRepository tasksRepository;

    public Tasks(PersonRepository personRepository, TasksRepository tasksRepository) {
        this.personRepository = personRepository;
        this.tasksRepository = tasksRepository;
    }


    @RequestMapping(value = {"/tasks"}, method = RequestMethod.GET)
    public String getTasks(Model model) {
        List<Task> item = tasksRepository.findAll();
        model.addAttribute("items", item);
        return "tasks/tasks";
    }


    @RequestMapping(value = {"/addTask"}, method = RequestMethod.GET)
    public String getAddTasks(Model model) {
        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);
        return "tasks/addTask";
    }



    @RequestMapping(value = {"/addNewTask"}, method = RequestMethod.POST)
    public RedirectView saveAddTask(@ModelAttribute Task newTask) {
        tasksRepository.save(newTask);
        return new RedirectView("/tasks");
    }



}
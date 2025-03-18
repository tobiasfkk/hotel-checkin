package com.example.hotelcheckin.controller;

import com.example.hotelcheckin.model.Person;
import com.example.hotelcheckin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.findAll();
    }

    @GetMapping("/search")
    public List<Person> search(@RequestParam String query) {
        return personService.search(query);
    }
}
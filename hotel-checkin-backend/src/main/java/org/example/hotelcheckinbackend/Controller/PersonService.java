package com.example.hotelcheckin.service;

import com.example.hotelcheckin.model.Person;
import com.example.hotelcheckin.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> search(String query) {
        return personRepository.findByNomeContainingOrDocumentoContaining(query, query);
    }
}
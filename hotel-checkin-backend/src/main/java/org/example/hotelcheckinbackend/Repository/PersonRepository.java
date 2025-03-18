package com.example.hotelcheckin.repository;

import com.example.hotelcheckin.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNomeContainingOrDocumentoContaining(String nome, String documento);
}
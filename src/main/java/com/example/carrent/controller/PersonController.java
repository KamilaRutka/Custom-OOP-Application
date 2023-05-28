package com.example.carrent.controller;

import com.example.carrent.model.Person;
import com.example.carrent.model.Rent;
import com.example.carrent.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
class PersonController {

    private PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPerson() {
        return ResponseEntity.ok(personService.getPersons());
    }

}

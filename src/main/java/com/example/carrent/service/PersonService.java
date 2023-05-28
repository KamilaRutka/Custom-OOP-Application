package com.example.carrent.service;

import com.example.carrent.model.Person;
import com.example.carrent.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService implements ApplicationRunner {

    private PersonRepository personRepository;

    public void addNewPerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void run(ApplicationArguments args) {
        this.addNewPerson(Person.builder()
                .firstName("Jon").lastName("Nowak").age(40).email("jon.nowak@wp.pl").build());
        this.addNewPerson(Person.builder()
                .firstName("Elizabeth").lastName("Nowak").age(30).email("elizabeth.nowak@wp.pl").build());
        this.addNewPerson(Person.builder()
                .firstName("Arthur").lastName("Morgan").age(55).email("dutch@gang.com").build());


    }
}

package org.gazievgeorgii.wishlist.controller;

import org.gazievgeorgii.wishlist.business.PersonManager;
import org.gazievgeorgii.wishlist.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonManager personManager;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPersons() {
        return personManager.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody Person person) {
        return personManager.addPerson(person);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Person updatePerson(@RequestBody Person person) {
        return personManager.updatePerson(person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id) {
        personManager.deletePerson(id);
    }
}

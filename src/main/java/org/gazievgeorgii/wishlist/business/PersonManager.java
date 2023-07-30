package org.gazievgeorgii.wishlist.business;

import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.domain.Person;
import org.gazievgeorgii.wishlist.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonManager {

    @Autowired
    private PersonRepository personRepository;

    public Person addMockPerson() {
        log.info("addMockPerson is called");
        Person person = new Person();
        person.setFirstname("Test firstname " + System.currentTimeMillis());
        person.setLastname("Test lastname " + System.currentTimeMillis());
        person.setBirthday(LocalDate.of(1999, 3, 10));
        person.setWishes(new ArrayList<>());
        person.setCreatedOn(LocalDateTime.now());
        person.setUpdatedOn(LocalDateTime.now());
        return personRepository.save(person);
    }

    public Person addPerson(Person person) {
        log.info("addPerson is called");
        person.setCreatedOn(LocalDateTime.now());
        person.setUpdatedOn(LocalDateTime.now());
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        log.info("updatePerson is called");
        Person savedPerson = personRepository.findByIdExact(person.getId());
        savedPerson.setBirthday(person.getBirthday());
        savedPerson.setFirstname(person.getFirstname());
        savedPerson.setLastname(person.getLastname());
        savedPerson.setWishes(person.getWishes());

        savedPerson.setUpdatedOn(LocalDateTime.now());
        return personRepository.save(savedPerson);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findByIdExact(Long id) {
        return personRepository.findByIdExact(id);
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}

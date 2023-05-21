package org.gazievgeorgii.wishlist.business;

import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.domain.Person;
import org.gazievgeorgii.wishlist.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Person addMockPerson() {
        log.info("addMockPerson is called");
        Person person = new Person();
        person.setFirstName("Test firstname " + System.currentTimeMillis());
        person.setLastName("Test lastname " + System.currentTimeMillis());
        person.setBirthday(LocalDate.of(1999, 3, 10));
        person.setWishList(new ArrayList<>());
        person.setCreatedOn(LocalDateTime.now());
        person.setUpdatedOn(LocalDateTime.now());
        return personRepository.save(person);
    }

    @Transactional
    public Person addPerson(Person person) {
        log.info("addPerson is called");
        person.setCreatedOn(LocalDateTime.now());
        person.setUpdatedOn(LocalDateTime.now());
        return personRepository.save(person);
    }

    @Transactional
    public Person updatePerson(Person person) {
        log.info("updatePerson is called");
        Person savedPerson = personRepository.findById(person.getId())
                .orElseThrow(() -> new RuntimeException("Failed to find a person with id [" + person.getId() + "]"));
        savedPerson.setBirthday(person.getBirthday());
        savedPerson.setFirstName(person.getFirstName());
        savedPerson.setLastName(person.getLastName());
        savedPerson.setWishList(person.getWishList());

        savedPerson.setUpdatedOn(LocalDateTime.now());
        return personRepository.save(savedPerson);
    }

    @Transactional
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Transactional
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Transactional
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}

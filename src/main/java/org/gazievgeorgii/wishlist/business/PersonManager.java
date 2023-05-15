package org.gazievgeorgii.wishlist.business;

import lombok.extern.slf4j.Slf4j;
import org.gazievgeorgii.wishlist.domain.Person;
import org.gazievgeorgii.wishlist.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonManager {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Long addUser() {
        log.info("Add used is called");
        Person person = new Person();
        person.setFirstName("Test first name");
        person.setLastName("Test last name");
        person.setBirthday(LocalDate.of(1999, 3, 10));
        return personRepository.save(person).getId();
    }

    @Transactional
    public Optional<Person> findById(Long id){
        return personRepository.findById(id);
    }

    @Transactional
    public List<Person> findAll(){
        return personRepository.findAll();
    }
}

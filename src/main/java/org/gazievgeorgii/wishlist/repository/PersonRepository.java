package org.gazievgeorgii.wishlist.repository;

import org.gazievgeorgii.wishlist.domain.Person;
import org.gazievgeorgii.wishlist.repository.exceptions.PersonNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();

    Optional<Person> findById(Long id);

    default Person findByIdExact(Long id) {
        return findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Failed to find a person with id [" + id + "]"));
    }
}

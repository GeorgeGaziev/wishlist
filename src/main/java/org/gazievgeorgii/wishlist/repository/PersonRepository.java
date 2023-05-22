package org.gazievgeorgii.wishlist.repository;

import org.gazievgeorgii.wishlist.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();

    default Person findByIdExact(Long id){
        return findById(id)
                .orElseThrow(() -> new RuntimeException("Failed to find a person with id [" + id + "]"));
    }
}

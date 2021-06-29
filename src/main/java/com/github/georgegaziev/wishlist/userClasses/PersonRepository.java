package com.github.georgegaziev.wishlist.userClasses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "person")
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastName(@Param("name") String name);

    Person findById(@Param("id") long id);

}
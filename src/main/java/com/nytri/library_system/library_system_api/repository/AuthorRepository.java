package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByFirstNameContains (String firstName);
    List<Author> findByLastNameContains (String lastName);
    List<Author> findByMiddleNameContains (String middleName);
    Author findByFirstName (String firstName);
    Author findByLastName (String lastName);
    Author findByMiddleName (String middleName);
}
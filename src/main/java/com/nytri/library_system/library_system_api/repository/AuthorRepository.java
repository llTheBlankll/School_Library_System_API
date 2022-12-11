package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findByFirstNameContaining (String firstName);
    Author findByLastNameContaining (String lastName);
    Author findByMiddleNameContaining (String middleName);
}
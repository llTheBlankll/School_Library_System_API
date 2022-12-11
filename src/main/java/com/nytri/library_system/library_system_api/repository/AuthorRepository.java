package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByFirstNameContaining (String firstName);
    List<Author> findByLastNameContaining (String lastName);
    List<Author> findByMiddleNameContaining (String middleName);
}
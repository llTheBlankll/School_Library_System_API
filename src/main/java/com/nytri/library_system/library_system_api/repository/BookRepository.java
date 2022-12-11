package com.nytri.library_system.library_system_api.repository;


import com.nytri.library_system.library_system_api.entities.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends org.springframework.data.jpa.repository.JpaRepository<com.nytri.library_system.library_system_api.entities.Book, Integer> {

    Book findByAuthorContains(String author);
    Book findByBookGenreContains(String genre);
}
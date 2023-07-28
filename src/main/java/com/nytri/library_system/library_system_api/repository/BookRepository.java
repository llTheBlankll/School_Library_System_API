package com.nytri.library_system.library_system_api.repository;


import com.nytri.library_system.library_system_api.entities.Author;
import com.nytri.library_system.library_system_api.entities.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends org.springframework.data.jpa.repository.JpaRepository<com.nytri.library_system.library_system_api.entities.Book, Integer> {
    List<Book> findByBookGenreContains(String genre);
    List<Book> findByLanguage(String language);
    List<Book> findByTitleContains(String title);
    List<Book> findByBookAuthor(Author author);
}
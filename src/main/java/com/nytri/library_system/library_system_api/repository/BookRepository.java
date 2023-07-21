package com.nytri.library_system.library_system_api.repository;


import com.nytri.library_system.library_system_api.entities.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends org.springframework.data.jpa.repository.JpaRepository<com.nytri.library_system.library_system_api.entities.Book, Integer> {
    List<Book> findByBookGenreContains(String genre);
    Book findByBookAuthor(int authorId);
}
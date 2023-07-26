package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Author;
import java.util.List;

public interface IAuthor {
    void addAuthor(Author author);
    void deleteAuthor(Author author);
    void deleteAuthorById(Integer authorId);
    void updateAuthor(Author author);
    List<Author> searchAuthorByFirstName(String firstName);
    List<Author> searchAuthorByLastName(String lastName);
    List<Author> searchAuthorByMiddleName(String middleName);
    Author getAuthorById(Integer authorId);
    List<Author> getAllAuthors();

}

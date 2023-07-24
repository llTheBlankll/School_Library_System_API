package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Author;
import java.util.List;

public interface IAuthor {
    void addAuthor(Author author);
    void deleteAuthor(Author author);
    void deleteAuthorById(Integer author_id);
    void updateAuthor(Author author);
    Author getAuthorById(Integer author_id);
    List<Author> getAllAuthors();

}

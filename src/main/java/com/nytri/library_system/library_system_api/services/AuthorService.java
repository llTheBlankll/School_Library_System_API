package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Author;
import com.nytri.library_system.library_system_api.interfaces.IAuthor;
import com.nytri.library_system.library_system_api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class AuthorService implements IAuthor {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        Assert.notNull(authorRepository, "AuthorRepository must not be null");
        this.authorRepository = authorRepository;
    }

     public boolean process(Author author) {
        // Returns true if it is Empty, false otherwise.
        return !author.getFirstName().isEmpty() && !author.getLastName().isEmpty();
    }

    @Override
    public void addAuthor(Author author) {
        if (this.process(author)) {
            authorRepository.save(author);
        }
    }

    @Override
    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public void deleteAuthorById(Integer authorId) {
        authorRepository.deleteById(authorId);
    }

    @Override
    public void updateAuthor(Author author) {
        if (this.process(author)) {
            authorRepository.save(author);
        }
    }

    @Override
    public Author getAuthorById(Integer authorId) {
        return authorRepository.findById(authorId).orElse(new Author());
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> searchAuthorByFirstName(String firstName) {
        return authorRepository.findByFirstNameContains(firstName);
    }

    @Override
    public List<Author> searchAuthorByLastName(String lastName) {
        return authorRepository.findByLastNameContains(lastName);
    }

    @Override
    public List<Author> searchAuthorByMiddleName(String middleName) {
        return authorRepository.findByMiddleNameContains(middleName);
    }
}

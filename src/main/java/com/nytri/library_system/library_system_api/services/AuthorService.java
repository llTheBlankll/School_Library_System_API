package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Author;
import com.nytri.library_system.library_system_api.interfaces.IAuthor;
import com.nytri.library_system.library_system_api.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        logger.info("Author was deleted with an ID of " + author.getId());
    }

    @Override
    public void deleteAuthorById(Integer author_id) {
        authorRepository.deleteById(author_id);
        logger.info("Author was deleted with an ID of " + author_id);
    }

    @Override
    public void updateAuthor(Author author) {
        if (this.process(author)) {
            authorRepository.save(author);
        }

        logger.info("Author was not updated with an ID of " + author.getId());
    }

    @Override
    public Author getAuthorById(Integer author_id) {
        return authorRepository.findById(author_id).orElse(new Author());
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}

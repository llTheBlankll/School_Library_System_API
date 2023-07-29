package com.nytri.library_system.library_system_api.controllers.librarian;

import com.nytri.library_system.library_system_api.entities.Author;
import com.nytri.library_system.library_system_api.services.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api_v1/librarian/authors")
public class AuthorsController {

    private final Logger logger = LoggerFactory.getLogger(AuthorsController.class);
    private final AuthorService authorService;

    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/author/{authorId}")
    public Author getAuthorById(@PathVariable Integer authorId) {
        return authorService.getAuthorById(authorId);
    }

    @PutMapping("/add")
    public void addAuthor(@RequestBody Author author) {
        if (author != null) {
            authorService.addAuthor(author);
            logger.info("Author was added successfully.");
        }

        logger.info("Author was not added.");
    }

    @DeleteMapping("/delete/{authorId}")
    public void deleteAuthorById(@PathVariable Integer authorId) {
        authorService.deleteAuthorById(authorId);
        logger.info("Author was deleted successfully.");
    }

    @DeleteMapping("/delete")
    public void deleteAuthor(Author author) {
        authorService.deleteAuthor(author);
        logger.info("Author was deleted successfully.");
    }

    @PutMapping("/update")
    public void updateAuthor(@RequestBody Author author) {
        authorService.updateAuthor(author);
        logger.info("Author was updated successfully.");
    }

    // SEARCH METHODS //
    @GetMapping("/firstName")
    public List<Author> searchAuthorByFirstName(String search) {
        return authorService.searchAuthorByFirstName(search);
    }

    @GetMapping("/lastName")
    public List<Author> searchAuthorByLastName(String search) {
        return authorService.searchAuthorByLastName(search);
    }

    @GetMapping("/middleName")
    public List<Author> searchAuthorByMiddleName(String search) {
        return authorService.searchAuthorByMiddleName(search);
    }
}

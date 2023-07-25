package com.nytri.library_system.library_system_api.controllers.Librarian;

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

    @GetMapping("/author/{author_id}")
    public Author getAuthorById(@PathVariable Integer author_id) {
        return authorService.getAuthorById(author_id);
    }

    @PutMapping("/add")
    public void addAuthor(@RequestBody Author author) {
        if (author != null) {
            authorService.addAuthor(author);
            logger.info("Author was added successfully.");
        }

        logger.info("Author was not added.");
    }

    @DeleteMapping("/delete/{author_id}")
    public void deleteAuthorById(@PathVariable Integer author_id) {
        authorService.deleteAuthorById(author_id);
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
}

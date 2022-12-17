package com.nytri.library_system.library_system_api.controllers.Library;


import com.nytri.library_system.library_system_api.entities.Author;
import com.nytri.library_system.library_system_api.repository.AuthorRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/librarian/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController (AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/all")
    public List<Author> getAll() {
        return this.authorRepository.findAll();
    }


}

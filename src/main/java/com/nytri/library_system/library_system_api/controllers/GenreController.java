package com.nytri.library_system.library_system_api.controllers;

import com.nytri.library_system.library_system_api.entities.Genre;
import com.nytri.library_system.library_system_api.repository.GenreRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/librarian/genre")
public class GenreController {

    private final GenreRepository genreRepository;

    public GenreController (GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/all")
    public List<Genre> getAll() {
        return this.genreRepository.findAll();
    }
}

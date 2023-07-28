package com.nytri.library_system.library_system_api.controllers.librarian;

import com.nytri.library_system.library_system_api.entities.Genre;
import com.nytri.library_system.library_system_api.services.GenresService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api_v1/librarian/genres")
public class GenresController {

    private final Logger logger = LoggerFactory.getLogger(GenresController.class);
    private final GenresService genresService;

    @Autowired
    public GenresController(GenresService genresService) {
        this.genresService = genresService;
    }

    @GetMapping("/genres")
    public List<Genre> getAllGenres() {
        logger.info("Getting all genres");
        return genresService.getAllGenres();
    }

    @GetMapping("/genres/{id}")
    public Genre getGenreById(@PathVariable int id) {
        logger.info("Getting genre by id: " + id);
        return genresService.getGenreById(id);
    }

    @PutMapping("/add")
    public void addGenre(@RequestBody Genre genre) {
        logger.info("Adding genre: " + genre);
        if (genresService.process(genre)) {
            genresService.addGenre(genre);
        }

        logger.info("Genre " + genre + " was not added");
    }

    @PutMapping("/update")
    public void updateGenre(@RequestBody Genre genre) {
        logger.info("Updating genre: " + genre);
        if (genresService.process(genre)) {
            genresService.updateGenre(genre);
        }

        logger.info("Genre " + genre + " was not updated");
    }

    @DeleteMapping("/delete")
    public void deleteGenre(@RequestBody Genre genre) {
        logger.info("Deleting genre: " + genre);
        if (genresService.process(genre)) {
            genresService.deleteGenre(genre);
        }

        logger.info("Genre " + genre + " was not deleted");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGenreById(@PathVariable int id) {
        logger.info("Deleting genre by id: " + id);
        genresService.deleteGenreById(id);

        logger.info("Genre " + id + " was not deleted");
    }

    @GetMapping("/search/name/{name}")
    public List<Genre> searchGenres(@PathVariable String name) {
        logger.info("Searching for genre: " + name);
        return genresService.findGenresByName(name);
    }
}
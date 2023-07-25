package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Genre;
import com.nytri.library_system.library_system_api.interfaces.IGenre;
import com.nytri.library_system.library_system_api.repository.GenreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class GenresService implements IGenre {

    private final GenreRepository genreRepository;

    @Autowired
    public GenresService(GenreRepository genreRepository) {
        Assert.notNull(genreRepository, "GenreRepository must not be null");
        this.genreRepository = genreRepository;
    }

    public boolean process(Genre genre) {
        // Returns true if it is Empty, false otherwise.
        return !genre.getGenre().isEmpty();
    }

    @Override
    public void addGenre(Genre genre) {
        if (this.process(genre)) {
            genreRepository.save(genre);
        }
    }

    @Override
    public void updateGenre(Genre genre) {
        if (this.process(genre)) {
            genreRepository.save(genre);
        }
    }

    @Override
    public void deleteGenre(Genre genre) {
        genreRepository.delete(genre);
    }

    @Override
    public void deleteGenreById(Integer genre_id) {
        genreRepository.deleteById(genre_id);
    }

    @Override
    public Genre getGenreById(Integer genre_id) {
        return genreRepository.findById(genre_id).orElse(new Genre());
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> findGenresByName(String genre) {
        return genreRepository.findByGenreContainsIgnoreCase(genre);
    }
}

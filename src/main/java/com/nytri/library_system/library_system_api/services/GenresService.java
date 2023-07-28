package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Genre;
import com.nytri.library_system.library_system_api.interfaces.IGenre;
import com.nytri.library_system.library_system_api.repository.GenreRepository;
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
        return !genre.getGenres().isEmpty();
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
    public void deleteGenreById(Integer genreId) {
        genreRepository.deleteById(genreId);
    }

    @Override
    public Genre getGenreById(Integer genreId) {
        return genreRepository.findById(genreId).orElse(new Genre());
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

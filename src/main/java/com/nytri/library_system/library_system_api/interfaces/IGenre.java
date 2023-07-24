package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Genre;

import java.util.List;

public interface IGenre {
    void addGenre(Genre genre);
    void updateGenre(Genre genre);
    void deleteGenre(Genre genre);
    void deleteGenreById(Integer genre_id);
    Genre getGenreById(Integer genre_id);
    List<Genre> getAllGenres();
}
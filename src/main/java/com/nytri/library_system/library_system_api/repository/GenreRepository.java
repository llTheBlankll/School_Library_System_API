package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findByGenreContainsIgnoreCase(String genre);
    Genre findByGenre(String genreName);
}
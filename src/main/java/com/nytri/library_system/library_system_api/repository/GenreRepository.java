package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    Genre findByGenre (String genre);
}
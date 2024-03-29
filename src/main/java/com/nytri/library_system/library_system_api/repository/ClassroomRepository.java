package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    List<Classroom> findBySectionNameContains (String sectionName );
    List<Classroom> findByAdviserFirstName(String firstName);
    List<Classroom> findByAdviserLastName(String lastName);
    List<Classroom> findByAdviserEmail(String email);
}
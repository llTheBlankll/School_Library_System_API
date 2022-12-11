package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    Classroom findBySectionNameContains ( String sectionName );
}
package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmail ( String email );
    Student findByFirstNameContains ( String firstName);
    Student findByLastNameContains ( String lastName );
}
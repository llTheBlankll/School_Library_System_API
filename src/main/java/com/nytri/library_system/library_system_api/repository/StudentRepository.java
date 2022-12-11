package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmail ( String email );
    List<Student> findByFirstNameContains (String firstName);
    List<Student> findByLastNameContains ( String lastName );
}
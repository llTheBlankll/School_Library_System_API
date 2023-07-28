package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByEmailContains ( String email );
    List<Student> findByFirstNameContains (String firstName);
    List<Student> findByLastNameContains ( String lastName );
    List<Student> findByMiddleNameContains (String middleName);
    List<Student> findByPhoneContains(String phoneNumber);
}
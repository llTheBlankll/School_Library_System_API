package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Borrower;
import com.nytri.library_system.library_system_api.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {

    Borrower findByStudent(Student studentId);
    List<Borrower> findByIssuedByContains(int employeeId);
}
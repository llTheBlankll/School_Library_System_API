package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstNameContains (String firstName );
    List<Employee> findByLastNameContains ( String lastName );
    List<Employee> findByMiddleNameContains (String middleName );
    List<Employee> findByEmailContains ( String email );
    Employee findByJobTitle ( String jobTitle );
}
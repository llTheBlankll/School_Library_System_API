package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByFirstNameContains (String firstName );
    Employee findByLastNameContains ( String lastName );
    Employee findByMiddleNameContains (String middleName );
    Employee findByEmailContains ( String email );
    Employee findByJobTitle ( String jobTitle );
}
package com.nytri.library_system.library_system_api.controllers;

import com.nytri.library_system.library_system_api.entities.Employee;
import com.nytri.library_system.library_system_api.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/administrator/employees")
@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController( EmployeeRepository employeeRepository ) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }


}

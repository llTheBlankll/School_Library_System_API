package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Employee;

import java.util.List;

public interface IEmployee {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void deleteEmployeeById(Integer employeeId);
    Employee getEmployeeById(Integer employeeId);
    List<Employee> searchEmployeesByLastName(String lastName);
    List<Employee> searchEmployeesByFirstName(String firstName);
    List<Employee> searchEmployeesByMiddleName(String middleName);
    List<Employee> searchEmployeesByJob(String position);
    List<Employee> searchEmployeesByEmail(String email);
    List<Employee> getAllEmployees();

}

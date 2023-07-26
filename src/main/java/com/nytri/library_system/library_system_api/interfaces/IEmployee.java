package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Employee;

import java.util.List;

public interface IEmployee {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void deleteEmployeeById(Integer employeeId);
    Employee getEmployeeById(Integer employee_id);
    List<Employee> searchEmployeeByLastName(String lastName);
    List<Employee> searchEmployeeByFirstName(String firstName);
    List<Employee> searchEmployeeByMiddleName(String middleName);
    List<Employee> searchEmployeeByJob(String position);
    List<Employee> getAllEmployees();

}

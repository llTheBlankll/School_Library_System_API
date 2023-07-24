package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Employee;

import java.util.List;

public interface IEmployee {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    Employee getEmployeeById(Integer employee_id);
    List<Employee> getAllEmployees();

}

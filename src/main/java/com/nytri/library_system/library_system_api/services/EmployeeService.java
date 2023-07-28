package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Employee;
import com.nytri.library_system.library_system_api.interfaces.IEmployee;
import com.nytri.library_system.library_system_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class EmployeeService implements IEmployee {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        Assert.notNull(employeeRepository, "EmployeeRepository must not be null");
        this.employeeRepository = employeeRepository;
    }

    public boolean process(Employee employee) {
        if (employee.getJobTitle().isEmpty()) {
            return false;
        }

        if (employee.getLastName().isEmpty()) {
            return false;
        }

        return employee.getHireDate() != null;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (this.process(employee)) {
            employeeRepository.save(employee);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (this.process(employee)) {
            employeeRepository.save(employee);
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

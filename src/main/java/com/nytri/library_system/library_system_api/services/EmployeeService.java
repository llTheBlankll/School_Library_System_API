package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Employee;
import com.nytri.library_system.library_system_api.interfaces.IEmployee;
import com.nytri.library_system.library_system_api.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class EmployeeService implements IEmployee {

    private final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        Assert.notNull(employeeRepository, "EmployeeRepository must not be null");
        this.employeeRepository = employeeRepository;
    }

    private boolean process(Employee employee) {
        if (employee.getJobTitle().isEmpty()) {
            return false;
        }

        if (employee.getLastName().isEmpty()) {
            return false;
        }

        return !(employee.getHireDate() == null);
    }

    @Override
    public void addEmployee(Employee employee) {
        if (this.process(employee)) {
            employeeRepository.save(employee);
        }
        logger.info("Employee was not added with an ID of " + employee.getId());
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (this.process(employee)) {
            employeeRepository.save(employee);
        }
        logger.info("Employee was not updated with an ID of " + employee.getId());
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
        logger.info("Employee was deleted with an ID of " + employee.getId());
    }

    @Override
    public Employee getEmployeeById(Integer employee_id) {
        return employeeRepository.findById(employee_id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

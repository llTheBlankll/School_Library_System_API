package com.nytri.library_system.library_system_api.controllers.Administrator;

import com.nytri.library_system.library_system_api.entities.Employee;
import com.nytri.library_system.library_system_api.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api_v1/admin/employees")
public class EmployeesController {

    private final Logger logger = LoggerFactory.getLogger(EmployeesController.class);
    private final EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/add")
    public void addEmployee(@RequestBody Employee employee) {
        if (employeeService.process(employee)) {
            employeeService.addEmployee(employee);
            logger.info("Employee added");
        } else {
            logger.info("Employee not added");
        }
    }

    @PostMapping("/update")
    public void updateEmployee(@RequestBody Employee employee) {
        if (employeeService.process(employee)) {
            employeeService.updateEmployee(employee);
            logger.info("Employee updated");
        } else {
            logger.info("Employee not updated");
        }
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestBody Employee employee) {
        if (employeeService.process(employee)) {
            employeeService.deleteEmployee(employee);
            logger.info("Employee deleted");
        } else {
            logger.info("Employee not deleted");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        logger.info("Employee deleted");
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }
}

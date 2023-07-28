package com.nytri.library_system.library_system_api.controllers.librarian;

import com.nytri.library_system.library_system_api.entities.Student;
import com.nytri.library_system.library_system_api.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api_v1/librarian/students")
public class StudentsController {

    private final Logger logger = LoggerFactory.getLogger(StudentsController.class);
    private final StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        if (id == 0) {
            return new Student();
        }

        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        if (id == 0) {
            return;
        }
        studentService.deleteStudent(id);
    }

    @PutMapping("/add")
    public void addStudent(@RequestBody Student student) {
        if (studentService.validateStudent(student)) {
            studentService.addStudent(student);
        }

        logger.info("Student " + student.getId() + " added.");
    }

    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        if (studentService.validateStudent(student)) {
            studentService.updateStudent(student);
        }

        logger.info("Student " + student.getId() + " updated.");
    }
}

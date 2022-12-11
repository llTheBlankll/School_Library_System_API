package com.nytri.library_system.library_system_api.controllers;

import com.nytri.library_system.library_system_api.entities.Student;
import com.nytri.library_system.library_system_api.repository.StudentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/librarian/student")
@CrossOrigin
@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController( StudentRepository studentRepository ) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/all")
    public List<Student> getAll() {
        return this.studentRepository.findAll();
    }
}

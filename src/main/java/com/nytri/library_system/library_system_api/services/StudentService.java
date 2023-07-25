package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Student;
import com.nytri.library_system.library_system_api.interfaces.IStudent;
import com.nytri.library_system.library_system_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class StudentService implements IStudent {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        Assert.notNull(studentRepository, "StudentRepository must not be null");
        this.studentRepository = studentRepository;
    }

    public boolean validateStudent(Student student) {
        return !student.getLastName().isEmpty();
    }

    @Override
    public void updateStudent(Student student) {
        // If returns true, the data provided is valid.
        if (validateStudent(student)) {
            studentRepository.save(student);
        }
    }

    @Override
    public void deleteStudent(Integer student_id) {
        // If returns true, the data provided is valid.
        studentRepository.deleteById(student_id);
    }

    @Override
    public void addStudent(Student student) {
        // If returns true, the data provided is valid.
        if (validateStudent(student)) {
            studentRepository.save(student);
        }
    }

    @Override
    public Student getStudentById(Integer student_id) {
        return studentRepository.findById(student_id).orElse(new Student());
    }

    @Override
    public List<Student> getAllStudent() {
        // Return all students' information.
        return studentRepository.findAll();
    }
}

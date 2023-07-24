package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Student;
import com.nytri.library_system.library_system_api.interfaces.IStudent;
import com.nytri.library_system.library_system_api.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudent {

    @Autowired
    private final StudentRepository studentRepository;
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private boolean validateStudent(Student student) {
        return !student.getLastName().isEmpty();
    }

    @Override
    public void updateStudent(Student student) {
        // If returns true, the data provided is valid.
        if (validateStudent(student)) {
            studentRepository.save(student);
        }

        logger.info("Student was not updated with an ID of " + student.getId());
    }

    @Override
    public void deleteStudent(Integer student_id) {
        // If returns true, the data provided is valid.
        studentRepository.deleteById(student_id);
        logger.info("Student was deleted with an ID of " + student_id);
    }

    @Override
    public void addStudent(Student student) {
        // If returns true, the data provided is valid.
        if (validateStudent(student)) {
            studentRepository.save(student);
        }

        logger.info("Student was not added with an ID of " + student.getId());
    }

    @Override
    public List<Student> getAllStudent() {
        // Return all students' information.
        return studentRepository.findAll();
    }
}

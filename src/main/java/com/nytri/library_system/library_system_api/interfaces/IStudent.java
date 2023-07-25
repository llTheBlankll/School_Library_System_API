package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Student;

import java.util.List;

public interface IStudent {
    void updateStudent(Student student);
    void deleteStudent(Integer student_id);
    void addStudent(Student student);
    Student getStudentById(Integer student_id);
    List<Student> getAllStudent();
}

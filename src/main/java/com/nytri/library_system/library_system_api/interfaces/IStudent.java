package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Student;

import java.util.List;

public interface IStudent {
    void updateStudent(Student student);
    void deleteStudent(Integer studentId);
    void addStudent(Student student);
    List<Student> getStudentByLastName(String lastName);
    List<Student> getStudentByFirstName(String firstName);
    List<Student> getStudentByMiddleName(String middleName);
    List<Student> getStudentByEmailAddress(String emailAddress);
    List<Student> getStudentByPhoneNumber(String phoneNumber);
    Student getStudentById(Integer studentId);
    List<Student> getAllStudent();
}

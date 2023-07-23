package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentInterface {
    void updateStudent(Long student_id);
    void deleteStudent(Long student_id);
    void addStudent(Student student);
    List<Student> getAllStudent();
}

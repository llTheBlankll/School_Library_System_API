package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Borrower;
import com.nytri.library_system.library_system_api.entities.Student;

import java.util.List;

public interface IBorrower {
    void addBorrower(Borrower borrower);
    void deleteBorrower(Borrower borrower);
    void deleteBorrowerById(Integer borrowerId);
    void updateBorrower(Borrower borrower);
    List<Borrower> searchBorrowerByStudent(Student student);


    List<Borrower> searchBorrowerByBookTitle(String bookName);
    List<Borrower> searchStudentByFirstName(String firstName);
    List<Borrower> searchStudentByLastName(String lastName);
    Borrower getBorrowerById(Integer borrowerId);
    List<Borrower> getAllBorrowers();

}

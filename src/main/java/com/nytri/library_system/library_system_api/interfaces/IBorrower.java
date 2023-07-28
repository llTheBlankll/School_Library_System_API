package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Borrower;

import java.util.List;

public interface IBorrower {
    void addBorrower(Borrower borrower);
    void deleteBorrower(Borrower borrower);
    void deleteBorrowerById(Integer borrowerId);
    void updateBorrower(Borrower borrower);
    List<Borrower> searchBorrowerByStudent(String studentName);
    List<Borrower> searchBorrowerByBook(String bookName);
    Borrower getBorrowerById(Integer borrowerId);
    List<Borrower> getAllBorrowers();

}

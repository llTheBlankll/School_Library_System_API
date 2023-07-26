package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Borrower;

import java.util.List;

public interface IBorrower {
    void addBorrower(Borrower Borrower);
    void deleteBorrower(Borrower Borrower);
    void deleteBorrowerById(Integer borrower_id);
    void updateBorrower(Borrower Borrower);
    List<Borrower> searchBorrowerByStudent(String student_name);
    List<Borrower> searchBorrowerByBook(String book_name);
    Borrower getBorrowerById(Integer borrower_id);
    List<Borrower> getAllBorrowers();

}

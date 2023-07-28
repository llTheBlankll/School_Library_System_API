package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Borrower;
import com.nytri.library_system.library_system_api.interfaces.IBorrower;
import com.nytri.library_system.library_system_api.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class BorrowerService implements IBorrower {

    private final BorrowerRepository borrowerRepository;

    @Autowired
    public BorrowerService(BorrowerRepository borrowerRepository) {
        Assert.notNull(borrowerRepository, "BorrowerRepository must not be null");
        this.borrowerRepository = borrowerRepository;
    }

     public boolean process(Borrower borrower) {
        if (borrower.getStudent() == null) {
            return false;
        }

        return !borrower.getBookBorrowed().getTitle().isEmpty();
    }

    @Override
    public void addBorrower(Borrower borrower) {
        if (this.process(borrower)) {
            borrowerRepository.save(borrower);
        }
    }

    @Override
    public void deleteBorrower(Borrower borrower) {
        borrowerRepository.delete(borrower);
    }

    @Override
    public void deleteBorrowerById(Integer borrowerId) {
        borrowerRepository.deleteById(borrowerId);
    }

    @Override
    public void updateBorrower(Borrower borrower) {
        if (this.process(borrower)) {
            borrowerRepository.save(borrower);
        }
    }

    @Override
    public List<Borrower> searchBorrowerByStudent(String studentName) {
        return null;
    }

    @Override
    public List<Borrower> searchBorrowerByBook(String bookName) {
        return null;
    }

    @Override
    public Borrower getBorrowerById(Integer borrowerId) {
        return borrowerRepository.findById(borrowerId).orElse(new Borrower());
    }

    @Override
    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }


}

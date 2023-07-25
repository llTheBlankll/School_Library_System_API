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
    public void addBorrower(Borrower Borrower) {
        if (this.process(Borrower)) {
            borrowerRepository.save(Borrower);
        }
    }

    @Override
    public void deleteBorrower(Borrower Borrower) {
        borrowerRepository.delete(Borrower);
    }

    @Override
    public void deleteBorrowerById(Integer borrower_id) {
        borrowerRepository.deleteById(borrower_id);
    }

    @Override
    public void updateBorrower(Borrower Borrower) {
        if (this.process(Borrower)) {
            borrowerRepository.save(Borrower);
        }
    }

    @Override
    public Borrower getBorrowerById(Integer borrower_id) {
        return borrowerRepository.findById(borrower_id).orElse(new Borrower());
    }

    @Override
    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }
}

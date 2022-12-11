package com.nytri.library_system.library_system_api.controllers;


import com.nytri.library_system.library_system_api.entities.Borrower;
import com.nytri.library_system.library_system_api.repository.BorrowerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/librarian/borrower")
public class BorrowerController {

    private final BorrowerRepository borrowerRepository;

    public BorrowerController (BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public List<Borrower> getAll() {
        return this.borrowerRepository.findAll();
    }


}

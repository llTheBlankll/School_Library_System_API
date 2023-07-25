package com.nytri.library_system.library_system_api.controllers.Librarian;

import com.nytri.library_system.library_system_api.entities.Borrower;
import com.nytri.library_system.library_system_api.services.BorrowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api_v1/librarian/borrowers")
public class BorrowersController {

    private final Logger logger = LoggerFactory.getLogger(BorrowersController.class);
    private final BorrowerService borrowerService;

    @Autowired
    public BorrowersController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @GetMapping("/borrowers")
    public List<Borrower> getAllBorrowers() {
        return borrowerService.getAllBorrowers();
    }

    @GetMapping("/borrower/{borrower_id}")
    public Borrower getBorrowerById(@PathVariable Integer borrower_id) {
        return borrowerService.getBorrowerById(borrower_id);
    }

    @PutMapping("/add")
    public void addBorrower(@RequestBody Borrower borrower) {
        if (borrowerService.process(borrower)) {
            borrowerService.addBorrower(borrower);
            logger.info("Borrower added successfully");
        }

        logger.info("Borrower " + borrower.getId() + " was not added");
    }

    @DeleteMapping("/delete")
    public void deleteBorrower(@RequestBody Borrower borrower) {
        if (borrowerService.process(borrower)) {
            borrowerService.deleteBorrower(borrower);
            logger.info("Borrower deleted successfully");
        }

        logger.info("Borrower " + borrower.getId() + " was not deleted");
    }

    @DeleteMapping("/delete/{borrower_id}")
    public void deleteBorrowerById(@PathVariable Integer borrower_id) {
        borrowerService.deleteBorrowerById(borrower_id);
        logger.info("Borrower deleted successfully");
    }

    @PostMapping("/update")
    public void updateBorrower(@RequestBody Borrower borrower) {
        if (borrowerService.process(borrower)) {
            borrowerService.updateBorrower(borrower);
            logger.info("Borrower updated successfully");
        }

        logger.info("Borrower " + borrower.getId() + " was not updated");
    }
}

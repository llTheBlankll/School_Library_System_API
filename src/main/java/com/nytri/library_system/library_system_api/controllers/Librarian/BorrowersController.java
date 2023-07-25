package com.nytri.library_system.library_system_api.controllers.Librarian;

import com.nytri.library_system.library_system_api.services.BorrowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}

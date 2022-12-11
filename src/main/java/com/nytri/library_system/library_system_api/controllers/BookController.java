package com.nytri.library_system.library_system_api.controllers;

import com.nytri.library_system.library_system_api.entities.Book;
import com.nytri.library_system.library_system_api.repository.BookRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/librarian/book")
public class BookController {

    private final BookRepository bookRepository;

    public BookController (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/all")
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }


}

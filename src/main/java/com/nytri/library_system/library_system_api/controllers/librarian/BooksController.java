package com.nytri.library_system.library_system_api.controllers.librarian;

import com.nytri.library_system.library_system_api.entities.Book;
import com.nytri.library_system.library_system_api.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api_v1/librarian/books")
public class BooksController {
    private final Logger logger = LoggerFactory.getLogger(BooksController.class);
    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{bookId}")
    public Book getBookById(@PathVariable Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/book/add")
    public void addBook(@RequestBody Book book) {
        if (bookService.process(book)) {
            bookService.addBook(book);
            logger.info("Book added successfully");
        }

        logger.info(String.format("Book %s added successfully", book.getTitle()));
    }

    @DeleteMapping("/book/delete")
    public void deleteBook(@RequestBody Book book) {
        if (bookService.process(book)) {
            bookService.deleteBook(book);
            logger.info("Book deleted successfully");
        }

        logger.info(String.format("Book %s deleted successfully", book.getTitle()));
    }

    @DeleteMapping("/book/delete/{bookId}")
    public void deleteBookById(@PathVariable Integer bookId) {
        bookService.deleteBookById(bookId);
        logger.info("Book deleted successfully");
    }

    @PostMapping("/book/update")
    public void updateBook(@RequestBody Book book) {
        if (bookService.process(book)) {
            bookService.updateBook(book);
            logger.info("Book updated successfully");
        }

        logger.info("Book " + book.getTitle() + " was not updated");
    }
}

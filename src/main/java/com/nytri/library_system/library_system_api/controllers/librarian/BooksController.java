package com.nytri.library_system.library_system_api.controllers.librarian;

import com.nytri.library_system.library_system_api.entities.Author;
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

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/add")
    public void addBook(@RequestBody Book book) {
        if (bookService.process(book)) {
            bookService.addBook(book);
            logger.info("Book added successfully");
        }

        logger.info(String.format("Book %s added successfully", book.getTitle()));
    }

    @DeleteMapping("/delete")
    public void deleteBook(@RequestBody Book book) {
        if (bookService.process(book)) {
            bookService.deleteBook(book);
            logger.info("Book deleted successfully");
        }

        logger.info(String.format("Book %s deleted successfully", book.getTitle()));
    }

    @DeleteMapping("/delete/{bookId}")
    public void deleteBookById(@PathVariable Integer bookId) {
        bookService.deleteBookById(bookId);
        logger.info("Book deleted successfully");
    }

    @PostMapping("/update")
    public void updateBook(@RequestBody Book book) {
        if (bookService.process(book)) {
            bookService.updateBook(book);
            logger.info("Book updated successfully");
        }

        logger.info("Book " + book.getTitle() + " was not updated");
    }

    // SEARCH METHODS //
    @GetMapping("/title")
    public List<Book> searchBookByTitle(@RequestParam String search) {
        return bookService.searchBookByTitle(search);
    }

    @GetMapping("/lastName")
    public List<Book> searchBookByAuthorLastName(@RequestParam String search) {
        return bookService.searchBookByAuthorLastName(search);
    }

    @GetMapping("/middleName")
    public List<Book> searchBookByAuthorMiddleName(@RequestParam String search) {
        return bookService.searchBookByAuthorMiddleName(search);
    }

    @GetMapping("/firstName")
    public List<Book> searchBookByAuthorFirstName(@RequestParam String search) {
        return bookService.searchBookByAuthorFirstName(search);
    }

    @GetMapping("/bookGenre")
    public List<Book> searchBookByGenreName(@RequestParam String search) {
        return bookService.searchBookByGenreName(search);
    }

    @GetMapping("/author")
    public List<Book> searchBookByAuthor(@RequestBody Author author) {
        return bookService.searchBookByAuthor(author);
    }

    @GetMapping("/language")
    public List<Book> searchBookByLanguage(@RequestParam String search) {
        return bookService.searchBookByLanguage(search);
    }
}

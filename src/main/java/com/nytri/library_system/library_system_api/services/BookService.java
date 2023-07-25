package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Book;
import com.nytri.library_system.library_system_api.interfaces.IBook;
import com.nytri.library_system.library_system_api.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class BookService implements IBook {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        Assert.notNull(bookRepository, "BookRepository must not be null");
        this.bookRepository = bookRepository;
    }

    public boolean process(Book book) {
        // Returns true if it is Empty, false otherwise.
        return book.getTitle().isEmpty() && !book.getBookAuthor().isValid();
    }

    @Override
    public void addBook(Book book) {
        if (this.process(book)) {
            bookRepository.save(book);
        }
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteBookById(Integer book_id) {
        bookRepository.deleteById(book_id);
    }

    @Override
    public void updateBook(Book book) {
        if (this.process(book)) {
            bookRepository.save(book);
        }
    }

    @Override
    public Book getBookById(Integer book_id) {
        return bookRepository.findById(book_id).orElse(new Book());
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

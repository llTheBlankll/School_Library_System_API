package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Book;

import java.util.List;

public interface IBook {
    void addBook(Book book);
    void deleteBook(Book book);
    void deleteBookById(Integer book_id);
    void updateBook(Book book);
    Book getBookById(Integer book_id);
    List<Book> getAllBooks();
}

package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Author;
import com.nytri.library_system.library_system_api.entities.Book;

import java.util.List;

public interface IBook {
    void addBook(Book book);
    void deleteBook(Book book);
    void deleteBookById(Integer book_id);
    void updateBook(Book book);
    List<Book> searchBookByTitle(String title);
    List<Book> searchBookByAuthorName(String authorName);
    List<Book> searchBookWithGenreName(String genreName);
    List<Book> searchBookByAuthor(Author author);
    Book getBookById(Integer bookId);
    List<Book> getAllBooks();
}

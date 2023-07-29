package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Author;
import com.nytri.library_system.library_system_api.entities.Book;
import com.nytri.library_system.library_system_api.interfaces.IBook;
import com.nytri.library_system.library_system_api.repository.AuthorRepository;
import com.nytri.library_system.library_system_api.repository.BookRepository;
import com.nytri.library_system.library_system_api.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class BookService implements IBook {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        Assert.notNull(bookRepository, "BookRepository must not be null");
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
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
    public void deleteBookById(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public void updateBook(Book book) {
        if (this.process(book)) {
            bookRepository.save(book);
        }
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepository.findById(bookId).orElse(new Book());
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBookByTitle(String title) {
        return bookRepository.findByTitleContains(title);
    }

    @Override
    public List<Book> searchBookByAuthorLastName(String authorLastName) {
        return bookRepository.findByBookAuthor(authorRepository.findByLastName(authorLastName));
    }

    @Override
    public List<Book> searchBookByAuthorFirstName(String authorFirstName) {
        return bookRepository.findByBookAuthor(authorRepository.findByFirstName(authorFirstName));
    }

    @Override
    public List<Book> searchBookByAuthorMiddleName(String authorFirstName) {
        return bookRepository.findByBookAuthor(authorRepository.findByMiddleName(authorFirstName));
    }

    @Override
    public List<Book> searchBookByGenreName(String genreName) {
        return bookRepository.findByBookGenreContains(genreRepository.findByGenres(genreName).getGenres());
    }

    @Override
    public List<Book> searchBookByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    @Override
    public List<Book> searchBookByAuthor(Author author) {
        return bookRepository.findByBookAuthor(author);
    }
}

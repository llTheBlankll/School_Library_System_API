package com.nytri.library_system.library_system_api.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @Column(name = "book_genre")
    private Integer bookGenre;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private Author author;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "language", length = 24)
    private String language;

    @Column(name = "total_pages")
    private Short totalPages;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column(name = "copies")
    private Integer copies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(Integer bookGenre) {
        this.bookGenre = bookGenre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Short getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Short totalPages) {
        this.totalPages = totalPages;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

}
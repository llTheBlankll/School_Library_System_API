package com.nytri.library_system.library_system_api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @Column(name = "genre_id", nullable = false)
    private Integer id;

    @Column(name = "genre")
    private String genres;

    @OneToOne(mappedBy = "bookGenre")
    private Book bookGenre;

    public Book getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(Book bookGenre) {
        this.bookGenre = bookGenre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

}
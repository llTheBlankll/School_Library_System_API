package com.nytri.library_system.library_system_api.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @Column(name = "author_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 48)
    private String firstName;

    @Column(name = "last_name", length = 48)
    private String lastName;

    @Column(name = "middle_name", length = 48)
    private String middleName;

    @OneToMany(mappedBy = "bookAuthor", cascade = CascadeType.ALL)
    private List<Book> booksWritten;
    public Author() {

    }

    public Author(Integer id, String firstName, String lastName, String middleName, List<Book> booksWritten) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.booksWritten = booksWritten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public boolean isValid() {
        if (this.id == 0) {
            return false;
        }

        return !this.lastName.isEmpty();
    }
}
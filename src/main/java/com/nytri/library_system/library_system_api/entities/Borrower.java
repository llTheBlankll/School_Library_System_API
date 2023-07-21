package com.nytri.library_system.library_system_api.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrower")
public class Borrower {
    @Id
    @Column(name = "borrower_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student")
    private Student student;

    @OneToOne
    @JoinColumn(name = "book")
    private Book bookBorrowed;

    @Column(name = "borrowed_from")
    private LocalDate borrowedFrom;

    @Column(name = "borrowed_to")
    private LocalDate borrowedTo;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "issued_by")
    private Integer issuedBy;

    public Book getBookBorrowed() {
        return bookBorrowed;
    }

    public void setBookBorrowed(Book bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getBorrowedFrom() {
        return borrowedFrom;
    }

    public void setBorrowedFrom(LocalDate borrowedFrom) {
        this.borrowedFrom = borrowedFrom;
    }

    public LocalDate getBorrowedTo() {
        return borrowedTo;
    }

    public void setBorrowedTo(LocalDate borrowedTo) {
        this.borrowedTo = borrowedTo;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(Integer issuedBy) {
        this.issuedBy = issuedBy;
    }

}
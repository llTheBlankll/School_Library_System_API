use school_library_system;

CREATE TABLE borrower (
    borrower_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    student INT UNIQUE,
    book INT UNIQUE,
    borrowed_from DATE,
    borrowed_to DATE,
    return_date DATE,
    issued_by INT UNIQUE, -- Employee
    FOREIGN KEY (student) REFERENCES student (student_id),
    FOREIGN KEY (book) REFERENCES books (id)
);
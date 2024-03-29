# noinspection SqlResolveForFile

/*
IMPORTANT NOTE:
Classrooms and Addresses data must be filled in before creating new table students data.
This is because of the FOREIGN KEY.
*/

CREATE DATABASE IF NOT EXISTS school_library_system;

use school_library_system;

-- Table for Employees (Teachers, Utility Personnel, etc...)
CREATE TABLE IF NOT EXISTS employees
(
    employee_id INT PRIMARY KEY NOT NULL,
    address_id  INT UNIQUE,
    first_name  VARCHAR(48),
    last_name   VARCHAR(48),
    middle_name VARCHAR(48),
    email       VARCHAR(128),
    phone       VARCHAR(24),
    job_title   VARCHAR(48),
    hire_date   DATE,
    salary      INT
);

CREATE TABLE IF NOT EXISTS addresses
(
    address_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    region     VARCHAR(48),
    street     VARCHAR(48),
    city       VARCHAR(48),
    country    VARCHAR(48),
    postcode   INT
);

CREATE TABLE IF NOT EXISTS classrooms
(
    classroom_id INT PRIMARY KEY NOT NULL,
    adviser      INT UNIQUE,
    section_name VARCHAR(48),
    FOREIGN KEY (adviser) REFERENCES employees (employee_id)
);

CREATE TABLE IF NOT EXISTS students
(
    student_id      INT PRIMARY KEY NOT NULL,
    student_address INT UNIQUE NULL,
    classroom_id    INT UNIQUE,
    first_name      VARCHAR(48),
    last_name       VARCHAR(48),
    middle_name     VARCHAR(48),
    email           VARCHAR(128),
    phone           VARCHAR(24),
    FOREIGN KEY (student_address) REFERENCES addresses (address_id),
    FOREIGN KEY (classroom_id) REFERENCES classrooms (classroom_id)
);

CREATE TABLE IF NOT EXISTS genres
(
    genre_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    genre    VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS authors
(
    author_id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name  VARCHAR(48),
    last_name   VARCHAR(48),
    middle_name VARCHAR(48)
);

CREATE TABLE IF NOT EXISTS books
(
    book_id        INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    book_genre     INT UNIQUE,
    author         INT UNIQUE,
    title          VARCHAR(255)    NOT NULL,
    description    TEXT,
    language       VARCHAR(24),
    total_pages    SMALLINT,
    published_date DATE,
    copies         INT,
    FOREIGN KEY (author) REFERENCES authors (author_id)
);

CREATE TABLE IF NOT EXISTS borrower
(
    borrower_id   INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    student       INT UNIQUE,
    book          INT UNIQUE,
    borrowed_from DATE,
    borrowed_to   DATE,
    return_date   DATE,
    issued_by     INT UNIQUE, -- Employee
    FOREIGN KEY (student) REFERENCES students (student_id),
    FOREIGN KEY (book) REFERENCES books (book_id)
);

-- Dummy Data
INSERT INTO addresses (region, street, postcode)
VALUES ("National Capital Region", "Fortune Drive, Canumay East", 1447);

INSERT INTO employees (employee_id, address_id, first_name, last_name, middle_name, email, phone, job_title, hire_date,
                       salary)
VALUES (125, 1, "Mary Grace", "Yap", "", "marygrace.yap@gmail.com", "Unknown", "Teacher", "2020-12-15", 20000);

INSERT INTO classrooms (classroom_id, adviser, section_name)
VALUES (308, 125, "Purity");

INSERT INTO students (student_id, student_address, classroom_id, first_name, last_name, middle_name, email, phone) VALUES (10113331, 1, 308, "Vince Angelo", "Batecan", "Olarte", "vbatecan@gmail.com", 09998216556);

INSERT INTO genres (genre)
VALUES ("Fantasy");

INSERT INTO authors (first_name, last_name, middle_name)
VALUES ("Vince Angelo", "Batecan", "Olarte");

INSERT INTO books (book_genre, author, title, description, language, total_pages, published_date, copies)
VALUES (1, 1, "Introduction to Programming", "The Introduction to Programming", "English", 100, "2006-11-2", 100);



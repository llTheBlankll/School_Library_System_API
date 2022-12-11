use school_library_system;

CREATE TABLE genres
(
    genre_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    genre    VARCHAR(255)
);

CREATE TABLE authors
(
    author_id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name  VARCHAR(48),
    last_name   VARCHAR(48),
    middle_name VARCHAR(48)
);

CREATE TABLE books
(
    book_id             INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
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
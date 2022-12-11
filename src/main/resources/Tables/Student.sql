use school_library_system;

CREATE TABLE IF NOT EXISTS student
(
    student_id      INT PRIMARY KEY NOT NULL,
    student_address INT UNIQUE,
    class_id        INT UNIQUE,
    first_name      VARCHAR(48),
    last_name       VARCHAR(48),
    middle_name     VARCHAR(48),
    email           VARCHAR(128),
    phone           VARCHAR(24)
);

INSERT INTO student (student_id, student_address, class_id, first_name, last_name, middle_name, email, phone)
VALUES (10113331, 1, 308, "Vince Angelo", "Batecan", "Olarte", "vbatecan@gmail.com", 09998216556);

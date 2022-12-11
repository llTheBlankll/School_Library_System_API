use school_library_system;

CREATE TABLE IF NOT EXISTS classrooms
(
    classroom_id INT PRIMARY KEY NOT NULL,
    adviser      INT UNIQUE,
    section_name VARCHAR(48),
    FOREIGN KEY (adviser) REFERENCES employees (employee_id)
);

INSERT INTO classrooms (classroom_id, adviser, section_name)
VALUES (308, 125, "Purity");

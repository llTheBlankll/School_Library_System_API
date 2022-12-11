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

INSERT INTO employees (employee_id, address_id, first_name, last_name, middle_name, email, phone, job_title, hire_date,
                       salary)
VALUES (125, 1, "Mary Grace", "Yap", "", "marygrace.yap@gmail.com", "Unknown", "Teacher", "2020-12-15", 20000);

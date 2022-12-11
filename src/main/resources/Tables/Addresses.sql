use school_library_system;

CREATE TABLE IF NOT EXISTS addresses
(
    address_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    student_id INT UNIQUE,
    region     VARCHAR(48),
    street     VARCHAR(48),
    postcode   SMALLINT,
    FOREIGN KEY (student_id) REFERENCES student (student_id)
);

INSERT INTO addresses (student_id, region, street, postcode)
VALUES (10113331, "National Capital Region", "Fortune Drive, Canumay East", 1447);

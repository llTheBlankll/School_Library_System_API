package com.nytri.library_system.library_system_api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = LibrarySystemApiApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpResponseTest {

    @Autowired
    private TestRestTemplate template;
    private final String username = "Administrator";
    private final String password = "50925092";

    @ParameterizedTest
    @ValueSource(strings = {"/api/administrator/employees"})
    void testEmployeeController(String url) {
        ResponseEntity<String> response = template.withBasicAuth(username, password)
                .getForEntity(url, String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"/api/administrator/employees"})
    void testAddressController(String url) {
        ResponseEntity<String> response = template.withBasicAuth(username, password)
                .getForEntity(url, String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @ParameterizedTest
    void testStudentController() {
        ResponseEntity<String> response = template.withBasicAuth(username, password)
                .getForEntity("/api/administrator/students/all", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testClassroomController() {
        ResponseEntity<String> response = template.withBasicAuth(username, password)
                .getForEntity("/api/administrator/classrooms/all", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testAuthorController() {
        ResponseEntity<String> response = template.withBasicAuth(username, password)
                .getForEntity("/api/librarian/authors/all", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testBookController() {
        ResponseEntity<String> response = template.withBasicAuth(username, password)
                .getForEntity("/api/librarian/books/all", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGenresController() {
        ResponseEntity<String> response = template.withBasicAuth(username, password)
                .getForEntity("/api/librarian/genres/all", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testBorrowerController() {
        ResponseEntity<String> response = template.withBasicAuth(username, password)
                .getForEntity("/api/librarian/borrowers/all", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}

package com.nytri.library_system.library_system_api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = LibrarySystemApiApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestControllerSecurityFilterChain {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testAuthorControllerSecurity() {
        ResponseEntity<String> response = template.withBasicAuth("invalid", "invalid")
                .getForEntity("/api_v1/librarian/authors/authors", String.class);
        Assertions.assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }
}

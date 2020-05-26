package dev.ravi.petclinic.data.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.List;

@DisplayName("Test Owner Class")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OwnerTest {

    private static Owner owner;

    @BeforeAll
    static void setUp() {
        owner = new Owner("Ravi","Kaliki");
    }

    @Test
    @Order(1)
    @DisplayName("Verify First Name")
    void getFirstName() {
       assertEquals("Ravi",owner.getFirstName());
    }

    @Test
    @Order(2)
    @DisplayName("Verify Last Name")
    void getLastName() {
        assertEquals("Kaliki",owner.getLastName());
    }
}
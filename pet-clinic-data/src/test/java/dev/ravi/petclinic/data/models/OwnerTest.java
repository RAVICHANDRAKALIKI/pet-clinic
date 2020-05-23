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
    @DisplayName("Add a Pet to the Owner")
    void ownPet() {
        Pet pet1 = new Pet("Tyzer",PetType.DOG);
        owner.ownPet(pet1);
    }

    @Test
    @Order(2)
    @DisplayName("Verify get PetList")
    void getPetList() {
        List<Pet> pets = owner.getPetList();
        assertTrue(pets.size() == 1);
        assertTrue(pets.get(0).getName().equals("Tyzer"));
    }

}
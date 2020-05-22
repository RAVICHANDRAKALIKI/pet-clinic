package dev.ravi.petclinic.data.models;

import org.aspectj.lang.annotation.Before;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Test Owner Class")
class OwnerTest {

    private static Owner owner;

    @BeforeAll
    static void setUp() {
        owner = new Owner("Ravi","Kaliki");
        owner.setId(Long.valueOf(1));
    }

    @Test
    @DisplayName("Verify get PetList")
    void getPetList() {
        List<Pet> pets = owner.getPetList();
        assertTrue(pets.size() == 1);
        assertTrue(pets.get(0).getName().equals("Tyzer"));
    }

    @Test
    @Before("getPetList")
    @DisplayName("Set the Owner PetList")
    void setPetList() {
        List<Pet> petList  = new ArrayList<>();
        Pet pet1 = new Pet("Tyzer",new PetType());
        pet1.setId(Long.valueOf(11));
        petList.add(pet1);
        owner.setPetList(petList);
    }
}
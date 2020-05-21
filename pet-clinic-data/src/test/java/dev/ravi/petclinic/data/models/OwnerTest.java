package dev.ravi.petclinic.data.models;

import org.aspectj.lang.annotation.Before;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Test Owner Class")
class OwnerTest {

    private static Owner owner;
    private static List<Pet> petList;

    @BeforeAll
    static void setUp() {
        owner = new Owner("Ravi","Kaliki");
        petList = new ArrayList<>();
        Pet pet1 = new Pet("Tyzer", owner, new PetType());
        petList.add(pet1);
    }

    @Test
    @DisplayName("Verify get PetList")
    void getPetList() {
        List<Pet> pets = owner.getPetList();
        assertTrue(pets.size() == 1);
        assertTrue(pets.get(0).getName().equals("Tyzer"));
        assertTrue(pets.get(0).getOwner().equals(owner));
    }

    @Test
    @Before("getPetList")
    @DisplayName("Set the Owner PetList")
    void setPetList() {
        owner.setPetList(petList);
    }
}
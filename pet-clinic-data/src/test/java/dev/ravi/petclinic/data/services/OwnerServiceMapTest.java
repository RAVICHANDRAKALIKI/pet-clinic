package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Owner;
import dev.ravi.petclinic.data.models.Pet;
import dev.ravi.petclinic.data.models.PetType;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Owner service Test")
class OwnerServiceMapTest {

    static OwnerServiceMap ownerServiceMap;

    @Test
    @Order(1)
    @DisplayName("Initialize DB")
    void setUp() {
        ownerServiceMap = new OwnerServiceMap();

    }

    @Test
    @Order(2)
    @DisplayName("Add Entries to Database")
    void save() {
        Owner owner = new Owner("Ravi", "Chandra");
        owner.setId(Long.valueOf(1));
        Pet pet = new Pet("Tyzer", new PetType());
        pet.setId(Long.valueOf(11));
        owner.getPetList().add(pet);
        ownerServiceMap.save(owner);

        Owner owner2 = new Owner("Ravi", "Kaliki");
        owner2.setId(Long.valueOf(2));
        Pet pet2 = new Pet("Tiger", new PetType());
        pet2.setId(Long.valueOf(12));
        owner2.getPetList().add(pet2);
        ownerServiceMap.save(owner2);

    }

    @Test
    @DisplayName("Verify Find All")
    @Order(3)
    void findAll() {
        assertEquals(2, ownerServiceMap.findAll().size(), "Find All Set length should be 2");
    }

    @Test
    @DisplayName("Verify Find by Id")
    @Order(4)
    void findById() {
        assertEquals("Ravi", ownerServiceMap.findById(Long.valueOf(1)).getFirstName());
        assertEquals("Chandra", ownerServiceMap.findById(Long.valueOf(1)).getLastName());
        assertEquals("Kaliki", ownerServiceMap.findById(Long.valueOf(2)).getLastName());
    }

    @Test
    @DisplayName("Delete by Id Test")
    @Order(5)
    void deleteById() {

        ownerServiceMap.deleteById(Long.valueOf(2));
    }

    @Test
    @DisplayName("Delete by Object")
    @Order(6)
    void delete() {

        Owner myOwner = ownerServiceMap.findById(Long.valueOf(1));
        Owner newOwner = new Owner(myOwner.getFirstName(), myOwner.getLastName());
        newOwner.setId(Long.valueOf(3));
        ownerServiceMap.save(newOwner);
        assertTrue(ownerServiceMap.findAll().size() == 2);
        ownerServiceMap.delete(myOwner);
        assertTrue(ownerServiceMap.findAll().size() == 1);
        assertEquals("Chandra", ownerServiceMap.findById(Long.valueOf(3)).getLastName(), "Last Name is not equal");

    }


}
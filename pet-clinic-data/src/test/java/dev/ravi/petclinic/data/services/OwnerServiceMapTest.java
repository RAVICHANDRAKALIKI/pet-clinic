package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Owner;
import dev.ravi.petclinic.data.models.Pet;
import dev.ravi.petclinic.data.models.PetType;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Owner service Test with Map Db")
class OwnerServiceMapTest {

    static OwnerService ownerService;
    static PetService petService;
    static PetTypeService petTypeService;

    @Test
    @Order(1)
    @DisplayName("Initialize DB")
    void setUp() {
        petService = new PetServiceMap() ;
        ownerService = new OwnerServiceMap(petService);
        petTypeService = new PetTypeServiceMap();
    }

    @Test
    @Order(2)
    @DisplayName("Add Entries to Database")
    void save() {

        PetType dog = new PetType("Dog");
        dog = petTypeService.save(dog);

        PetType cat = new PetType("Cat");
        cat = petTypeService.save(cat);

        PetType bunny = new PetType("Bunny");
        bunny = petTypeService.save(bunny);

        Owner owner1 = new Owner("Ravi", "Chandra");
        Pet pet1 = new Pet("Tyzer", dog);
        petService.save(pet1);
        owner1.ownPet(pet1);
        ownerService.save(owner1);

        Owner owner2 = new Owner("Ravi", "Kaliki");
        Pet pet2 = new Pet("Tiger", cat);
        petService.save(pet2);
        Pet pet3 = new Pet("Chintu", bunny);
        petService.save(pet3);
        owner2.ownPet(pet2).ownPet(pet3);
        ownerService.save(owner2);

    }

    @Test
    @DisplayName("Verify Find All")
    @Order(3)
    void findAll() {
        assertEquals(2, ownerService.findAll().size(), "Find All Set length should be 2");
        assertEquals(3, petService.findAll().size(), "Pets should be 2");

    }

    @Test
    @DisplayName("Verify Find by Id")
    @Order(4)
    void findById() {
        assertEquals("Ravi", ownerService.findById(1L).getFirstName());
        assertEquals("Chandra", ownerService.findById(1L).getLastName());
        assertEquals("Kaliki", ownerService.findById(2L).getLastName());
    }

    @Test
    @DisplayName("Delete by Id Test")
    @Order(5)
    void deleteById() {
        ownerService.deleteById(2L);
        assertEquals(1, ownerService.findAll().size(), "Find All Set length should be 1");
        assertEquals(1, petService.findAll().size(), "Find All Set length should be 1");

        assertEquals("Ravi", ownerService.findById(1L).getFirstName());
        assertEquals("Chandra", ownerService.findById(1L).getLastName());


    }

    @Test
    @DisplayName("Delete by Object")
    @Order(6)
    void delete() {
        Owner newOwner = new Owner("Jim", "Carrey");
        ownerService.save(newOwner);
        assertEquals(2, ownerService.findAll().size());
        assertEquals(1, petService.findAll().size());
        ownerService.delete(ownerService.findById(1L));
        assertEquals(1, ownerService.findAll().size());
        assertEquals(0, petService.findAll().size());
        assertEquals("Jim", ownerService.findById(3L).getFirstName(), "First Name is not equal");
        assertEquals("Carrey", ownerService.findById(3L).getLastName(), "Last Name is not equal");

    }


}
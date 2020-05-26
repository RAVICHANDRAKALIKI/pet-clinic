package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Owner;
import dev.ravi.petclinic.data.models.Pet;
import dev.ravi.petclinic.data.models.PetType;
import dev.ravi.petclinic.data.repositories.PetRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Owner service Test with Map Db")
class OwnerServiceMapTest {

    static OwnerServiceMap ownerService;
    static PetServiceMap petService;
    static PetTypeServiceMap petTypeService;

    @Test
    @Order(1)
    @DisplayName("Initialize DB")
    void setUp_MAP() {
        ownerService = new OwnerServiceMap();
        petService = new PetServiceMap(ownerService) ;
        ownerService.setPetService(petService);
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
        owner1 = ownerService.save(owner1);

        Pet pet1 = new Pet("Tyzer", dog, owner1);
        petService.save(pet1);

        Owner owner2 = new Owner("Ravi", "Kaliki");
        owner2 = ownerService.save(owner2);
        Pet pet2 = new Pet("Tiger", cat, owner2);
        petService.save(pet2);
        Pet pet3 = new Pet("Chintu", bunny, owner2);
        petService.save(pet3);

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
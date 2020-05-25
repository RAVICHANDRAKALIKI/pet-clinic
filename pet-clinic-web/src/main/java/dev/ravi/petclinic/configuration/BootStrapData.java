package dev.ravi.petclinic.configuration;

import dev.ravi.petclinic.data.models.*;
import dev.ravi.petclinic.data.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PetService petService;
    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final AppointmentService appointmentService;
    private final SpecialityService specialityService;

    public BootStrapData(PetService petService, VetService vetService, OwnerService ownerService, PetTypeService petTypeService, AppointmentService appointmentService, SpecialityService specialityService) {
        this.petService = petService;
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.appointmentService = appointmentService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog  = new PetType("Dog");
        dog = petTypeService.save(dog);
        PetType cat  = new PetType("Cat");
        cat = petTypeService.save(cat);
        PetType bunny  = new PetType("Bunny");
        bunny = petTypeService.save(bunny);

        Pet pet1 = new Pet("Tyzer", 2, 1, dog);
        petService.save(pet1);
        Pet pet2 = new Pet("BonBon", 1, 6, cat);
        petService.save(pet2);
        Owner owner1 = new Owner("Ravi", "Chandra");
        owner1.ownPet(pet1).ownPet(pet2);
        owner1.setAddress("8479 CRAGGAN LN");
        owner1.setCity("Manassas");
        owner1.setTelephone("123-456-7891");
        ownerService.save(owner1);

        Pet pet3 = new Pet("Chimpu", 0, 6, bunny);
        petService.save(pet3);
        Owner owner2 = new Owner("Riya", "Kaliki");
        owner2.ownPet(pet3);
        owner2.setAddress("1050 Alex Dr");
        owner2.setCity("North Brunswick");
        owner2.setTelephone("732-822-9745");
        ownerService.save(owner2);

        Owner owner3 = new Owner("Ushasee", "Das", "1050 Alex Dr", "North Brunswick", "848-220-0020");
        ownerService.save(owner3);

        Speciality speciality1 = new Speciality("Aviators");
        specialityService.save(speciality1);
        Speciality speciality2 = new Speciality("Mammals");
        specialityService.save(speciality2);
        Speciality speciality3 = new Speciality("Wild Ones");
        specialityService.save(speciality3);

        Vet vet1 = new Vet("John", "Hopkins");
        vet1.addSpeciality(speciality1);
        vet1.addSpeciality(speciality2);
        vetService.save(vet1);

        Vet vet2 = new Vet("Marie", "Curie");
        vet2.addSpeciality(speciality3);
        vetService.save(vet2);

        Appointment appointment1 = new Appointment(vet1, pet3,
                LocalDateTime.of(2020, Month.AUGUST, 10, 9, 0));
        appointmentService.save(appointment1);

        Appointment appointment2 = new Appointment(vet1, pet3,
                LocalDateTime.of(2020, Month.DECEMBER, 5, 9, 0));
        appointmentService.save(appointment2);

    }
}

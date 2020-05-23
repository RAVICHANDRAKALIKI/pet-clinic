package dev.ravi.petclinic.configuration;

import dev.ravi.petclinic.data.models.Owner;
import dev.ravi.petclinic.data.models.Pet;
import dev.ravi.petclinic.data.models.PetType;
import dev.ravi.petclinic.data.models.Vet;
import dev.ravi.petclinic.data.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PetService petService;
    private final VetService vetService;
    private final OwnerService ownerService;

    public BootStrapData(PetService petService, VetService vetService, OwnerService ownerService) {
        this.petService = petService;
        this.vetService = vetService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {
        Pet pet1 = new Pet("Tyzer", 2, 1, PetType.DOG);
        petService.save(pet1);
        Pet pet2 = new Pet("BonBon", 1, 6, PetType.CAT);
        petService.save(pet2);
        Owner owner1 = new Owner("Ravi", "Chandra");
        owner1.ownPet(pet1).ownPet(pet2);
        ownerService.save(owner1);

        Pet pet3 = new Pet("Bunny", 0, 6, PetType.BUNNY);
        petService.save(pet3);
        Owner owner2 = new Owner("Riya", "Kaliki");
        owner2.ownPet(pet3);
        ownerService.save(owner2);

        Vet vet1 = new Vet("John", "Hopkins");
        Vet vet2 = new Vet("Marie", "Curie");
        vetService.save(vet1);
        vetService.save(vet2);

    }
}

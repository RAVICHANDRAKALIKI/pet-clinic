package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Owner;
import dev.ravi.petclinic.data.models.Pet;
import dev.ravi.petclinic.data.repositories.AbstractMapDb;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("MAP")
public class PetServiceMap extends AbstractMapDb<Long, Pet>
                            implements PetService {

    private final OwnerService ownerService;

    public PetServiceMap(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public Pet save(Pet entity) {
        Owner owner = entity.getOwner();
        entity =  super.save(entity);
        owner.getPetList().add(entity);
        ownerService.save(owner);
        return entity;
    }
}

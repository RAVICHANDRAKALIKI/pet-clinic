package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Owner;
import dev.ravi.petclinic.data.repositories.AbstractMapDb;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapDb<Long, Owner>
                            implements OwnerService {

    private final PetService petService;
    public OwnerServiceMap(PetService petService) {
        this.petService = petService;
    }

    @Override
    public void delete(Owner entity) {
        entity.getPetList().forEach(pet -> petService.delete(pet));
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        findById(id).getPetList().forEach(pet -> petService.delete(pet));
        super.deleteById(id);
    }
}

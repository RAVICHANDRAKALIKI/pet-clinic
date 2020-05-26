package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Owner;
import dev.ravi.petclinic.data.repositories.AbstractMapDb;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("MAP")
public class OwnerServiceMap extends AbstractMapDb<Long, Owner>
                            implements OwnerService {

    private PetService petService;

    @Override
    public void delete(Owner entity) {
        entity.getPetList().forEach(pet -> petService.delete(pet));
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        System.out.println(findById(id).getPetList().size());
        findById(id).getPetList().forEach(pet -> petService.delete(pet));
        super.deleteById(id);
    }

    public void setPetService(PetService petService) {
        this.petService = petService;
    }
}

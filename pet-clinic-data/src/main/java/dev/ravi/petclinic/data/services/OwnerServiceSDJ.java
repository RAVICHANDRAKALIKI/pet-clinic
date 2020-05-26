package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Owner;
import dev.ravi.petclinic.data.repositories.OwnerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("SDJ")
public class OwnerServiceSDJ implements OwnerService{

    private OwnerRepository ownerRepository;

    public OwnerServiceSDJ(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> findAll() {
        ArrayList<Owner> owners = new ArrayList<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public void delete(Owner owner) {
         ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}

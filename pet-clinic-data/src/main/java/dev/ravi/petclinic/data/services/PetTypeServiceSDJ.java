package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.PetType;
import dev.ravi.petclinic.data.repositories.PetTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("SDJ")
public class PetTypeServiceSDJ implements PetTypeService {

    private PetTypeRepository petTypeRepository;

    public PetTypeServiceSDJ(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public List<PetType> findAll() {
        ArrayList<PetType> petTypes = new ArrayList<>() ;
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}

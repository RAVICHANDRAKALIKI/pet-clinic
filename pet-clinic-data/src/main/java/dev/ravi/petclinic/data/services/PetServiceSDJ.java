package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Pet;
import dev.ravi.petclinic.data.repositories.PetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("SDJ")
public class PetServiceSDJ implements PetService {

    private PetRepository petRepository;

    public PetServiceSDJ(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> findAll() {
        ArrayList<Pet> petArrayList = new ArrayList<>();
        petRepository.findAll().forEach(petArrayList::add);
        return petArrayList;
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}

package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Pet;

import java.util.List;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    List<Pet> findAll();
}

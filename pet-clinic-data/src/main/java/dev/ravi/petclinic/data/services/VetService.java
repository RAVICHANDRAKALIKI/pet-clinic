package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Vet;

import java.util.List;

public interface VetService {


    Vet findById(Long id);

    Vet save(Vet vet);

    List<Vet> findAll();
}

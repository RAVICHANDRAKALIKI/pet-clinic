package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Owner;

import java.util.List;

public interface OwnerService {

    Owner findById(Long id);

    Owner save(Owner owner);

    List<Owner> findAll();

}

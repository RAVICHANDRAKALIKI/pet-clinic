package dev.ravi.petclinic.data.repositories;

import dev.ravi.petclinic.data.models.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}

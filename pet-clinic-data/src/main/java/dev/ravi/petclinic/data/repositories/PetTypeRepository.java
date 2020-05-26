package dev.ravi.petclinic.data.repositories;

import dev.ravi.petclinic.data.models.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

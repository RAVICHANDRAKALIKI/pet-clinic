package dev.ravi.petclinic.data.repositories;

import dev.ravi.petclinic.data.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository  extends CrudRepository<Owner, Long> {
}

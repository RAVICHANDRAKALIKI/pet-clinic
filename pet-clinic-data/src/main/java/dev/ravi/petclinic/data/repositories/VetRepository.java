package dev.ravi.petclinic.data.repositories;

import dev.ravi.petclinic.data.models.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}

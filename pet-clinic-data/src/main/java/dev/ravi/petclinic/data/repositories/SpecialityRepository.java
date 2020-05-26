package dev.ravi.petclinic.data.repositories;

import dev.ravi.petclinic.data.models.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}

package dev.ravi.petclinic.data.repositories;

import dev.ravi.petclinic.data.models.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}

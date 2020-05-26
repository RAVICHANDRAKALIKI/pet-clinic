package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Appointment;
import dev.ravi.petclinic.data.repositories.AbstractMapDb;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("MAP")
public class AppointmentServiceMap extends AbstractMapDb<Long, Appointment>
                                implements AppointmentService {

    private VetService vetService;

    public AppointmentServiceMap(VetService vetService) {
        this.vetService = vetService;
    }

    @Override
    public Appointment save(Appointment entity) {
        Appointment appointment = super.save(entity);
        entity.getVet().addAppointment(appointment);
        vetService.save(entity.getVet());
        return  appointment;
    }
}

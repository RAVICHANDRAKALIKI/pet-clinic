package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Appointment;
import dev.ravi.petclinic.data.repositories.AppointmentRepository;
import dev.ravi.petclinic.data.repositories.VetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("SDJ")
public class AppointmentServiceSDJ implements AppointmentService{

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceSDJ(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment findById(Long aLong) {
        return appointmentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        appointmentRepository.findAll().forEach(appointments::add);
        return appointments;
    }

    @Override
    public void delete(Appointment appointment) {
        appointmentRepository.delete(appointment);
    }

    @Override
    public void deleteById(Long aLong) {
        appointmentRepository.deleteById(aLong);
    }
}

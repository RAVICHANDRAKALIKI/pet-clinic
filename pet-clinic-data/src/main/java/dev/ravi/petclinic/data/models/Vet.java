package dev.ravi.petclinic.data.models;

import java.util.List;

public class Vet extends Person {

    private List<Appointment> appointmentList;

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
}

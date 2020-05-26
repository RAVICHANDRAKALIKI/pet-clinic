package dev.ravi.petclinic.data.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vet extends Person {

    @ManyToMany
    @JoinTable(name = "vet_speciality",
                joinColumns = @JoinColumn(name="vet_id"),
                inverseJoinColumns = @JoinColumn(name="speciality_id"))
    private List<Speciality> specialities = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vet")
    private List<Appointment> appointmentList = new ArrayList<>();

    public void addSpeciality(Speciality speciality) {
        this.specialities.add(speciality);
    }

    public void addAppointment(Appointment appointment) {
        this.appointmentList.add(appointment);
    }
    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    public String getSpecialitiesAsString() {
        String asString = "";
        for(Speciality s: specialities) {
            if (asString.equals("")) {
                asString = asString.concat(s.getDescription());
            }
            else {
                asString = asString.concat(",").concat(s.getDescription());
            }
        }
        return asString;
    }
}

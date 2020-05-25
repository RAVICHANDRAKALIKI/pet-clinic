package dev.ravi.petclinic.data.models;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Vet extends Person {

    private List<Speciality> specialities = new ArrayList<>();
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

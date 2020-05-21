package dev.ravi.petclinic.data.models;

import java.time.LocalDate;

public class Appointment {

    private Pet pet;
    private LocalDate date;

    public Appointment(Pet pet, LocalDate date) {
        this.pet = pet;
        this.date = date;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}

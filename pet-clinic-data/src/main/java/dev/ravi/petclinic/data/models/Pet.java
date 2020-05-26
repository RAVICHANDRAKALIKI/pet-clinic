package dev.ravi.petclinic.data.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pet extends BaseEntity {

    @Column(name="name")
    private String name;

    @Column(name="age_years")
    private Integer ageYears;

    @Column(name="age_months")
    private Integer ageMonths;

    @ManyToOne
    private PetType petType;

    @ManyToOne
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.EAGER)
    List<Appointment> appointmentList = new ArrayList<>();

    public Pet(String name, PetType petType) {
        this.name = name;
        this.petType = petType;
        this.ageMonths = Integer.valueOf(0);
        this.ageYears = Integer.valueOf(0);
    }

    public Pet(String name, Integer ageYears, Integer ageMonths, PetType petType) {
        this.name = name;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Integer getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(Integer ageYears) {
        this.ageYears = ageYears;
    }

    public Integer getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(Integer ageMonths) {
        this.ageMonths = ageMonths;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
}

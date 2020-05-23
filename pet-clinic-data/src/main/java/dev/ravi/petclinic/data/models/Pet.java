package dev.ravi.petclinic.data.models;

public class Pet extends BaseEntity {

    private String name;
    private Integer ageYears;
    private Integer ageMonths;
    private PetType petType;

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
}

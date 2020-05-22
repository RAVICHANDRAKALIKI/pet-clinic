package dev.ravi.petclinic.data.models;

public class Pet extends BaseEntity {

    private String Name;
    private Integer ageYears;
    private Integer ageMonths;
    private PetType petType;

    public Pet(String name, PetType petType) {
        Name = name;
        this.petType = petType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

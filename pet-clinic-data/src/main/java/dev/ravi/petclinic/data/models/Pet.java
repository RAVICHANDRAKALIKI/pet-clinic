package dev.ravi.petclinic.data.models;

public class Pet extends BaseEntity {

    private String Name;
    private Integer ageYears;
    private Integer ageMonths;
    private Owner owner;
    private PetType petType;

    public Pet(String name, Owner owner, PetType petType) {
        Name = name;
        this.owner = owner;
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
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

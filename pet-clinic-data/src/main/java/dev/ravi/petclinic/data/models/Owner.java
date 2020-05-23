package dev.ravi.petclinic.data.models;


import java.util.ArrayList;
import java.util.List;

public class Owner extends Person{

    private List<Pet> petList = new ArrayList<>();

    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
        petList = new ArrayList<>();
    }

    public Owner ownPet(Pet pet) {
        petList.add(pet);
        return this;
    }
    public List<Pet> getPetList() {
        return petList;
    }

}

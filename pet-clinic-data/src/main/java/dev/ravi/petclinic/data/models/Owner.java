package dev.ravi.petclinic.data.models;


import java.util.ArrayList;
import java.util.List;

public class Owner extends Person{

    private List<Pet> petList;

    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
        petList = new ArrayList<>();
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

}

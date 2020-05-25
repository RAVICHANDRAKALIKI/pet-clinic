package dev.ravi.petclinic.data.models;


import java.util.ArrayList;
import java.util.List;

public class Owner extends Person{

    private String address;
    private String city;
    private String telephone;
    private List<Pet> petList = new ArrayList<>();

    public Owner(String firstName, String lastName, String address, String city, String telephone) {
        super(firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

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

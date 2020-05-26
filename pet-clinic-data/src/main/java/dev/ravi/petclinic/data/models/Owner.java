package dev.ravi.petclinic.data.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner extends Person{

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Pet> petList = new ArrayList<>();

    public Owner() {
        super();
    }

    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
    }

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

//    public Owner ownPet(Pet pet) {
//        petList.add(pet);
//        return this;
//    }
    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }
}

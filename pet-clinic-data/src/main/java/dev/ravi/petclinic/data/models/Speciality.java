package dev.ravi.petclinic.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Speciality extends BaseEntity{

    @Column(name="description")
    private String description;

    public Speciality() {
    }

    public Speciality(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

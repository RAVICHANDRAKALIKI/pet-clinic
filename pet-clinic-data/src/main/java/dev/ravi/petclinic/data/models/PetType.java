package dev.ravi.petclinic.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PetType extends BaseEntity {

        @Column(name="type")
        private String name;

        public PetType(String name) {
                this.name = name;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

}

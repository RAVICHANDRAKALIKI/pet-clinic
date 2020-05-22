package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Pet;
import dev.ravi.petclinic.data.repositories.AbstractMapDb;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapDb<Long, Pet>
                            implements PetService {

}

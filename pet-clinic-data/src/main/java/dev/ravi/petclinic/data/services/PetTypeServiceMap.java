package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.PetType;
import dev.ravi.petclinic.data.repositories.AbstractMapDb;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapDb<Long, PetType> implements PetTypeService {
}

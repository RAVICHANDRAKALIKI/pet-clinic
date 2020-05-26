package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.PetType;
import dev.ravi.petclinic.data.repositories.AbstractMapDb;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("MAP")
public class PetTypeServiceMap extends AbstractMapDb<Long, PetType> implements PetTypeService {
}

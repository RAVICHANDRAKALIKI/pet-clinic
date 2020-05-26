package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Vet;
import dev.ravi.petclinic.data.repositories.AbstractMapDb;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("MAP")
public class VetServiceMap extends AbstractMapDb<Long, Vet>
        implements VetService {
}

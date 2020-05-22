package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Vet;
import dev.ravi.petclinic.data.repositories.AbstractMapDb;
import org.springframework.stereotype.Service;


@Service
public class VetServiceMap extends AbstractMapDb<Long, Vet>
        implements VetService {
}

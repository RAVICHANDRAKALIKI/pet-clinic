package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Speciality;
import dev.ravi.petclinic.data.repositories.AbstractMapDb;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceMap extends AbstractMapDb<Long, Speciality> implements SpecialityService {
}

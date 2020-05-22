package dev.ravi.petclinic.data.services;


import dev.ravi.petclinic.data.models.Owner;
import dev.ravi.petclinic.data.repositories.AbstractMapDb;
import org.springframework.stereotype.Service;


@Service
public class OwnerServiceMap extends AbstractMapDb<Long, Owner>
                            implements OwnerService {

}

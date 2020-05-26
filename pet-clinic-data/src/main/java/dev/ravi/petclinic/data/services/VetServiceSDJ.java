package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Vet;
import dev.ravi.petclinic.data.repositories.VetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("SDJ")
public class VetServiceSDJ implements VetService{

    private VetRepository vetRepository;

    public VetServiceSDJ(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public List<Vet> findAll() {
        ArrayList<Vet> vetArrayList = new ArrayList<>();
        vetRepository.findAll().forEach(vetArrayList::add);
        return vetArrayList;
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}

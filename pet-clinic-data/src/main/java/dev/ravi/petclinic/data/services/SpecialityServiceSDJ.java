package dev.ravi.petclinic.data.services;

import dev.ravi.petclinic.data.models.Speciality;
import dev.ravi.petclinic.data.repositories.SpecialityRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("SDJ")
public class SpecialityServiceSDJ implements SpecialityService{

    private SpecialityRepository specialityRepository;

    public SpecialityServiceSDJ(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public List<Speciality> findAll() {
        ArrayList<Speciality> specialities = new ArrayList<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}

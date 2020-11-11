package sasha.burgazli.App.service.impl;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Faculty;
import sasha.burgazli.App.models.Speciality;
import sasha.burgazli.App.repositories.SpecialityRepository;
import sasha.burgazli.App.service.SpecialityService;
import sasha.burgazli.App.service.FacultyService;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository repository;

    public SpecialityServiceImpl(SpecialityRepository repository) {this.repository = repository;}


    @Override
    public List<Speciality> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<Speciality> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void save(Speciality speciality) {
        this.repository.save(speciality);
    }
}

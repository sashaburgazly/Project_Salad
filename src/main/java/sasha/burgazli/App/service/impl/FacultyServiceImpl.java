package sasha.burgazli.App.service.impl;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Faculty;
import sasha.burgazli.App.models.form.FacultyForm;
import sasha.burgazli.App.repositories.FacultyRepository;
import sasha.burgazli.App.service.FacultyService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository repository;

    public FacultyServiceImpl(FacultyRepository repository) {this.repository = repository;}


    @Override
    public List<Faculty> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<Faculty> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void save(Faculty faculty) {this.repository.save(faculty);
    }
}

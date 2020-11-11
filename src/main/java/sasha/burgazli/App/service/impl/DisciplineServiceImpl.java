package sasha.burgazli.App.service.impl;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Discipline;
import sasha.burgazli.App.models.form.DisciplineForm;
import sasha.burgazli.App.repositories.DisciplineRepository;
import sasha.burgazli.App.service.DisciplineService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepository repository;

    public DisciplineServiceImpl(DisciplineRepository repository) {this.repository = repository;}

    @Override
    public List<Discipline> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<Discipline> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void save(Discipline discipline) {this.repository.save(discipline);
    }
}

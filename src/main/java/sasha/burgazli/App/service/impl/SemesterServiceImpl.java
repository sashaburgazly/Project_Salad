package sasha.burgazli.App.service.impl;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Semester;
import sasha.burgazli.App.repositories.SemesterRepository;
import sasha.burgazli.App.service.SemesterService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SemesterServiceImpl implements SemesterService {

    private final SemesterRepository repository;

    public SemesterServiceImpl(SemesterRepository repository) {this.repository = repository;}


    @Override
    public List<Semester> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<Semester> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void save(Semester semester) {
        this.repository.save(semester);
    }
}

package sasha.burgazli.App.service.impl;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Mark;
import sasha.burgazli.App.repositories.MarkRepository;
import sasha.burgazli.App.service.MarkService;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements MarkService {

    private final MarkRepository repository;

    public MarkServiceImpl(MarkRepository repository) {this.repository = repository;}


    @Override
    public List<Mark> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<Mark> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void save(Mark mark) {
        this.repository.save(mark);
    }
}

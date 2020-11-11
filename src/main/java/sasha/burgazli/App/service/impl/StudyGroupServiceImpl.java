package sasha.burgazli.App.service.impl;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.StudyGroup;
import sasha.burgazli.App.repositories.StudyGroupRepository;
import sasha.burgazli.App.service.StudyGroupService;

import java.util.List;
import java.util.Optional;

@Service
public class StudyGroupServiceImpl implements StudyGroupService {

    private final StudyGroupRepository repository;

    public StudyGroupServiceImpl(StudyGroupRepository repository) {this.repository = repository;}


    @Override
    public List<StudyGroup> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<StudyGroup> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void save(StudyGroup studyGroup) {
        this.repository.save(studyGroup);
    }
}

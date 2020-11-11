package sasha.burgazli.App.service.impl;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.StudyPlan;
import sasha.burgazli.App.repositories.StudyPlanRepository;
import sasha.burgazli.App.service.StudyPlanService;

import java.util.List;
import java.util.Optional;

@Service
public class StudyPlanServiceImpl implements StudyPlanService {

    private final StudyPlanRepository repository;

    public StudyPlanServiceImpl(StudyPlanRepository repository) {this.repository = repository;}


    @Override
    public List<StudyPlan> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<StudyPlan> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void save(StudyPlan studyPlan) {
        this.repository.save(studyPlan);
    }
}

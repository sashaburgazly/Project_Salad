package sasha.burgazli.App.service;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.StudyPlan;


import java.util.List;
import java.util.Optional;

@Service
public interface StudyPlanService {
    List<StudyPlan> findAll();

    void delete(Long id);

    Optional<StudyPlan> findById(Long id);

    void save(StudyPlan studyPlan);
}

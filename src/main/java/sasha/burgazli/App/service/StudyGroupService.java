package sasha.burgazli.App.service;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.StudyGroup;


import java.util.List;
import java.util.Optional;

@Service
public interface StudyGroupService {
    List<StudyGroup> findAll();

    void delete(Long id);

    Optional<StudyGroup> findById(Long id);

    void save(StudyGroup studyGroup);
}

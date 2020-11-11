package sasha.burgazli.App.service;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Semester;

import java.util.List;
import java.util.Optional;

@Service
public interface SemesterService {
    List<Semester> findAll();

    void delete(Long id);

    Optional<Semester> findById(Long id);

    void save(Semester semester);
}

package sasha.burgazli.App.service;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Faculty;

import java.util.List;
import java.util.Optional;

@Service
public interface FacultyService {
    List<Faculty> findAll();

    void delete(Long id);

    Optional<Faculty> findById(Long id);

    void save(Faculty faculty);
}

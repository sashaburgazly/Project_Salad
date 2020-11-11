package sasha.burgazli.App.service;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Discipline;

import java.util.List;
import java.util.Optional;

@Service
public interface DisciplineService {
    List<Discipline> findAll();

    void delete(Long id);

    Optional<Discipline> findById(Long id);

    void save(Discipline discipline);
}

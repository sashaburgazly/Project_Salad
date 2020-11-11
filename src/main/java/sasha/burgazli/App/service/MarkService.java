package sasha.burgazli.App.service;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Mark;

import java.util.List;
import java.util.Optional;

@Service
public interface MarkService {
    List<Mark> findAll();

    void delete(Long id);

    Optional<Mark> findById(Long id);

    void save(Mark mark);
}

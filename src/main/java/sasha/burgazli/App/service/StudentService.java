package sasha.burgazli.App.service;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Student;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    List<Student> findAll();

    void delete(Long id);

    Optional<Student> findById(Long id);
}

package sasha.burgazli.App.service.impl;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Student;
import sasha.burgazli.App.repositories.StudentRepository;
import sasha.burgazli.App.service.StudentService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;


        for (int i = 0; i < 10; i++) {
            this.repository.save(new Student(String.valueOf(i),
                    String.valueOf(i),
                    String.valueOf(i),
                    new Date(), String.valueOf(i), String.valueOf(i)));
        }


    }


    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return this.repository.findById(id);
    }
}

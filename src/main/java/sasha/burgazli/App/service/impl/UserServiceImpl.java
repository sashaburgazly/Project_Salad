package sasha.burgazli.App.service.impl;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.StudyPlan;
import sasha.burgazli.App.models.User;
import sasha.burgazli.App.repositories.StudyPlanRepository;
import sasha.burgazli.App.repositories.UserRepository;
import sasha.burgazli.App.service.StudyPlanService;
import sasha.burgazli.App.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {this.repository = repository;}


    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void save(User user) {
        this.repository.save(user);
    }
}

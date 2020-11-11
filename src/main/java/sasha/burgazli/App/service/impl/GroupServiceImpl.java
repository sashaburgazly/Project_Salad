package sasha.burgazli.App.service.impl;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Group;
import sasha.burgazli.App.repositories.GroupRepository;
import sasha.burgazli.App.service.GroupService;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;

    public GroupServiceImpl(GroupRepository repository) {this.repository = repository;}


    @Override
    public List<Group> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<Group> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void save(Group group) {
        this.repository.save(group);
    }
}

package sasha.burgazli.App.service;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Group;

import java.util.List;
import java.util.Optional;

@Service
public interface GroupService {
    List<Group> findAll();

    void delete(Long id);

    Optional<Group> findById(Long id);

    void save(Group group);
}

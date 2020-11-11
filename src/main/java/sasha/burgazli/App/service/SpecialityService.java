package sasha.burgazli.App.service;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.Speciality;


import java.util.List;
import java.util.Optional;

@Service
public interface SpecialityService {
    List<Speciality> findAll();

    void delete(Long id);

    Optional<Speciality> findById(Long id);

    void save(Speciality speciality);
}

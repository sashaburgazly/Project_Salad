package sasha.burgazli.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasha.burgazli.App.models.Speciality;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}

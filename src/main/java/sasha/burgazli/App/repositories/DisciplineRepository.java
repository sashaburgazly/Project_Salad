package sasha.burgazli.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasha.burgazli.App.models.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}

package sasha.burgazli.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasha.burgazli.App.models.Semester;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
}

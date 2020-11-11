package sasha.burgazli.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasha.burgazli.App.models.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}

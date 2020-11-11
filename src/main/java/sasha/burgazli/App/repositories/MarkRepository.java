package sasha.burgazli.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasha.burgazli.App.models.Mark;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {
}

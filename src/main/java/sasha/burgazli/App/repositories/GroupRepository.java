package sasha.burgazli.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasha.burgazli.App.models.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}

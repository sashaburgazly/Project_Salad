package sasha.burgazli.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasha.burgazli.App.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

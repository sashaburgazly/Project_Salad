package sasha.burgazli.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sasha.burgazli.App.models.Users;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {

//    @Query(value = "select * from public.user where login=':login' and password=':password';", nativeQuery = true)
//    Optional<Users> authUser(@Param(value = "login") String login, @Param(value = "password") String password);

}

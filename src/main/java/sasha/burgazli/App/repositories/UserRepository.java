//package sasha.burgazli.App.repositories;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import sasha.burgazli.App.models.User;
//
//import java.util.Optional;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    @Query(value = "select * from public.user where login=':login' and password=':password';", nativeQuery = true)
//    Optional<User> authUser(@Param(value = "login") String login, @Param(value = "password") String password);
//
//    Optional<User> findByLogin(String login);
//
//
//
//}

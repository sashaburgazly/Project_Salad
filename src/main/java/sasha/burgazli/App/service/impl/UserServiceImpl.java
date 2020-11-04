//package sasha.burgazli.App.service.impl;
//
//import org.springframework.stereotype.Service;
//import sasha.burgazli.App.CommonService;
//import sasha.burgazli.App.models.User_Data;
//import sasha.burgazli.App.repositories.UserRepository;
//import sasha.burgazli.App.service.UserService;
//
//import java.util.Optional;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository repository;
//
//    public UserServiceImpl(UserRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public Optional<User_Data> authUser(String login, String password) {
//
//        if (login.isEmpty() || password.isEmpty()) {
//            return Optional.empty();
//        }
//
//
//        return repository.authUser(login, CommonService.md5(password));
//    }
//}

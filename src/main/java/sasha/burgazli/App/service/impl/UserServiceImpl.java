package sasha.burgazli.App.service.impl;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.CommonService;
import sasha.burgazli.App.models.User;
import sasha.burgazli.App.models.form.LoginForm;
import sasha.burgazli.App.repositories.UserRepository;
import sasha.burgazli.App.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> authUser(LoginForm form) {

        return repository.authUser(form.getLogin(), CommonService.md5(form.getPassword()));
    }
}

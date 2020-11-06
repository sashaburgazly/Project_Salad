package sasha.burgazli.App.service;

import org.springframework.stereotype.Service;
import sasha.burgazli.App.models.User;
import sasha.burgazli.App.models.form.LoginForm;
//import sasha.burgazli.App.models.User_Data;

import java.util.Optional;

@Service
public interface UserService {
    Optional<User> authUser(LoginForm loginForm);


}

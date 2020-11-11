package sasha.burgazli.App.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import sasha.burgazli.App.models.form.LoginForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private final JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private final PasswordEncoder passwordEncoder;


    public LoginController(JdbcUserDetailsManager jdbcUserDetailsManager, PasswordEncoder passwordEncoder) {
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
        this.passwordEncoder = passwordEncoder;
//        this.service = service;
    }

    @GetMapping(value = "/login")
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("loginForm", new LoginForm());
        mav.setViewName("index_log");
        return mav;
    }

    @PostMapping(value = "/login")
    public String loginForm(@ModelAttribute LoginForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/login";
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        UserDetails user = new User(form.getLogin(), passwordEncoder.encode(form.getPassword()), authorities);

        jdbcUserDetailsManager.createUser(user);

        jdbcUserDetailsManager.userExists(form.getLogin());

//        if (user.isEmpty()) {
//            return "redirect:/login";
//        }

        return "redirect:/student";
    }
}

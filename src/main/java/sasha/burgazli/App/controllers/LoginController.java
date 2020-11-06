package sasha.burgazli.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sasha.burgazli.App.models.User;
import sasha.burgazli.App.models.form.LoginForm;
import sasha.burgazli.App.service.UserService;

import java.util.Optional;

@Controller
public class LoginController {

    private final UserService service;

    public LoginController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/login")
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("loginForm", new LoginForm());
        mav.setViewName("index");
        return mav;
    }

    @PostMapping(value = "/login")
    public String loginForm(@ModelAttribute LoginForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/login";
        }

//        Optional<User> user = this.service.authUser(form);
//        if (user.isEmpty()) {
//            return "redirect:/login";
//        }

        return "redirect:/student";
    }
}

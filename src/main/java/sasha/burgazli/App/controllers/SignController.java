package sasha.burgazli.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sasha.burgazli.App.models.User;
import sasha.burgazli.App.models.form.SignForm;
//import sasha.burgazli.App.service.UserService;

import java.util.Optional;

@Controller
public class SignController {

//    private final UserService service;

    public SignController() {

    }

    @GetMapping(value = "/sign")
    public ModelAndView signPage() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("signForm", new SignForm());
        mav.setViewName("index_sign");
        return mav;
    }

    @PostMapping(value = "/signup")
    public String signForm(@ModelAttribute SignForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/sign";
        }

//        Optional<User> user = this.service.authUser(form);
//        if (user.isEmpty()) {
//            return "redirect:/login";
//        }

        return "redirect:/student";
    }
}

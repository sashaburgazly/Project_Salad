package sasha.burgazli.App.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
//import sasha.burgazli.App.repositories.PrivilegeRepository;
//import sasha.burgazli.App.repositories.RoleRepository;
//import sasha.burgazli.App.service.UserService;

import java.util.Optional;

@Controller
public class MainController {

//    @Autowired
//    private UserService userService;

    @GetMapping("/main")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index_log");


//        Optional<User_Data> optional = userService.authUser("test", "test");
//
//        if (optional.isPresent()) {
//
//        }

        return mav;
    }

    @GetMapping("/reg")
    public String openReg() {
        return "index_reg";
    }

    @GetMapping("/user")
    public String openUser() {
        return "user";
    }


}

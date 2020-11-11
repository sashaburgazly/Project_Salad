//package sasha.burgazli.App.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import sasha.burgazli.App.models.User;
//import sasha.burgazli.App.models.form.UserForm;
//import sasha.burgazli.App.service.UserService;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//public class UserController {
//
//    private final UserService service;
//
//    public UserController(UserService service) {
//        this.service = service;
//    }
//
//
//    @GetMapping(value = "/user")
//    private ModelAndView user() {
//
//        List<User> list = this.service.findAll();
//
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("user");
//        mav.addObject("users", list);
//
//        return mav;
//    }
//
//
//    @GetMapping(value = "/user/edit")
//    private ModelAndView edit(@RequestParam(value = "id") Long id) {
//
//        ModelAndView mav = new ModelAndView();
//
//        Optional<User> optional = this.service.findById(id);
//        if (optional.isPresent()) {
//
//            UserForm form = new UserForm(optional.get());
//
//            mav.setViewName("user_edit");
//            mav.addObject("userForm", form);
//        } else {
//            List<User> list = this.service.findAll();
//            mav.setViewName("user");
//            mav.addObject("users", list);
//        }
//
//        return mav;
//    }
//
//    @PostMapping(value = "/user/save")
//    private String save(UserForm form, BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "redirect:/edit";
//        }
//
//        Optional<User> optional = null;
//        if(form.getId() == null || form.getId().isEmpty()){
//            optional = Optional.empty();
//        }else {
//            optional = this.service.findById(Long.valueOf(form.getId()));
//        }
//
//
//        User user1 = null;
//        if (optional.isPresent()) {
//            user1 = optional.get();
//            user1.update(form);
//        } else {
//            user1 = new User(form);
//        }
//
//
//        this.service.save(user1);
//
//        return "redirect:/user";
//    }
//
//    @GetMapping(value = "/user/add")
//    private ModelAndView add() {
//
//        ModelAndView mav = new ModelAndView();
//        UserForm form = new UserForm();
//
//        mav.setViewName("user_edit");
//        mav.addObject("userForm", form);
//
//        return mav;
//    }
//
//
//    @GetMapping(value = "/user/delete")
//    private ModelAndView delete(@RequestParam(value = "id") Long id) {
//
//        this.service.delete(id);
//        List<User> list = this.service.findAll();
//
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("user");
//        mav.addObject("users", list);
//
//        return mav;
//    }
//}

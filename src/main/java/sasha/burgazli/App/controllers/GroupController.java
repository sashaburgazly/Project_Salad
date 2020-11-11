package sasha.burgazli.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sasha.burgazli.App.models.Group;
import sasha.burgazli.App.models.form.GroupForm;
import sasha.burgazli.App.service.GroupService;

import java.util.List;
import java.util.Optional;

@Controller
public class GroupController {

    private final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }


    @GetMapping(value = "/group")
    private ModelAndView group() {

        List<Group> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("group");
        mav.addObject("groups", list);

        return mav;
    }


    @GetMapping(value = "/group/edit")
    private ModelAndView edit(@RequestParam(value = "id") Long id) {

        ModelAndView mav = new ModelAndView();

        Optional<Group> optional = this.service.findById(id);
        if (optional.isPresent()) {

            GroupForm form = new GroupForm(optional.get());

            mav.setViewName("group_edit");
            mav.addObject("groupForm", form);
        } else {
            List<Group> list = this.service.findAll();
            mav.setViewName("group");
            mav.addObject("groups", list);
        }

        return mav;
    }

    @PostMapping(value = "/group/save")
    private String save(GroupForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/edit";
        }

        Optional<Group> optional = null;
        if(form.getId() == null || form.getId().isEmpty()){
            optional = Optional.empty();
        }else {
            optional = this.service.findById(Long.valueOf(form.getId()));
        }


        Group group1 = null;
        if (optional.isPresent()) {
            group1 = optional.get();
            group1.update(form);
        } else {
            group1 = new Group(form);
        }


        this.service.save(group1);

        return "redirect:/group";
    }

    @GetMapping(value = "/group/add")
    private ModelAndView add() {

        ModelAndView mav = new ModelAndView();
        GroupForm form = new GroupForm();

        mav.setViewName("group_edit");
        mav.addObject("groupForm", form);

        return mav;
    }


    @GetMapping(value = "/group/delete")
    private ModelAndView delete(@RequestParam(value = "id") Long id) {

        this.service.delete(id);
        List<Group> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("group");
        mav.addObject("groups", list);

        return mav;
    }
}

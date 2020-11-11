package sasha.burgazli.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sasha.burgazli.App.models.Faculty;
import sasha.burgazli.App.models.form.FacultyForm;
import sasha.burgazli.App.service.FacultyService;

import java.util.List;
import java.util.Optional;

@Controller
public class FacultyController {

    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }


    @GetMapping(value = "/faculty")
    private ModelAndView faculty() {

        List<Faculty> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("faculty");
        mav.addObject("facultys", list);

        return mav;
    }


    @GetMapping(value = "/faculty/edit")
    private ModelAndView edit(@RequestParam(value = "id") Long id) {

        ModelAndView mav = new ModelAndView();

        Optional<Faculty> optional = this.service.findById(id);
        if (optional.isPresent()) {

            FacultyForm form = new FacultyForm(optional.get());

            mav.setViewName("faculty_edit");
            mav.addObject("facultyForm", form);
        } else {
            List<Faculty> list = this.service.findAll();
            mav.setViewName("faculty");
            mav.addObject("facultys", list);
        }

        return mav;
    }

    @PostMapping(value = "/faculty/save")
    private String save(FacultyForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/edit";
        }

        Optional<Faculty> optional = null;
        if(form.getId() == null || form.getId().isEmpty()){
            optional = Optional.empty();
        }else {
            optional = this.service.findById(Long.valueOf(form.getId()));
        }


        Faculty faculty1 = null;
        if (optional.isPresent()) {
            faculty1 = optional.get();
            faculty1.update(form);
        } else {
            faculty1 = new Faculty(form);
        }


        this.service.save(faculty1);

        return "redirect:/faculty";
    }

    @GetMapping(value = "/faculty/add")
    private ModelAndView add() {

        ModelAndView mav = new ModelAndView();
        FacultyForm form = new FacultyForm();

        mav.setViewName("faculty_edit");
        mav.addObject("facultyForm", form);

        return mav;
    }


    @GetMapping(value = "/faculty/delete")
    private ModelAndView delete(@RequestParam(value = "id") Long id) {

        this.service.delete(id);
        List<Faculty> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("faculty");
        mav.addObject("facultys", list);

        return mav;
    }
}

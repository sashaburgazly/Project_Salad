package sasha.burgazli.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sasha.burgazli.App.models.Semester;
import sasha.burgazli.App.models.form.SemesterForm;
import sasha.burgazli.App.service.SemesterService;

import java.util.List;
import java.util.Optional;

@Controller
public class SemesterController {

    private final SemesterService service;

    public SemesterController(SemesterService service) {
        this.service = service;
    }


    @GetMapping(value = "/semester")
    private ModelAndView semester() {

        List<Semester> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("semester");
        mav.addObject("semesters", list);

        return mav;
    }


    @GetMapping(value = "/semester/edit")
    private ModelAndView edit(@RequestParam(value = "id") Long id) {

        ModelAndView mav = new ModelAndView();

        Optional<Semester> optional = this.service.findById(id);
        if (optional.isPresent()) {

            SemesterForm form = new SemesterForm(optional.get());

            mav.setViewName("semester_edit");
            mav.addObject("semesterForm", form);
        } else {
            List<Semester> list = this.service.findAll();
            mav.setViewName("semester");
            mav.addObject("semesters", list);
        }

        return mav;
    }

    @PostMapping(value = "/semester/save")
    private String save(SemesterForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/edit";
        }

        Optional<Semester> optional = null;
        if(form.getId() == null || form.getId().isEmpty()){
            optional = Optional.empty();
        }else {
            optional = this.service.findById(Long.valueOf(form.getId()));
        }


        Semester semester1 = null;
        if (optional.isPresent()) {
            semester1 = optional.get();
            semester1.update(form);
        } else {
            semester1 = new Semester(form);
        }


        this.service.save(semester1);

        return "redirect:/semester";
    }

    @GetMapping(value = "/semester/add")
    private ModelAndView add() {

        ModelAndView mav = new ModelAndView();
        SemesterForm form = new SemesterForm();

        mav.setViewName("semester_edit");
        mav.addObject("semesterForm", form);

        return mav;
    }


    @GetMapping(value = "/semester/delete")
    private ModelAndView delete(@RequestParam(value = "id") Long id) {

        this.service.delete(id);
        List<Semester> list = this.service.findAll();


        ModelAndView mav = new ModelAndView();
        mav.setViewName("semester");
        mav.addObject("semesters", list);

        return mav;
    }
}

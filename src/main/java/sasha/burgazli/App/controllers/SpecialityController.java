package sasha.burgazli.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sasha.burgazli.App.models.Faculty;
import sasha.burgazli.App.models.Speciality;
import sasha.burgazli.App.models.form.SpecialityForm;
import sasha.burgazli.App.service.FacultyService;
import sasha.burgazli.App.service.SpecialityService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class SpecialityController {

    private final SpecialityService service;
    private final FacultyService facultyService;

    public SpecialityController(SpecialityService service, FacultyService facultyService) {
        this.service = service;
        this.facultyService = facultyService;
    }


    @GetMapping(value = "/speciality")
    private ModelAndView speciality() {

        List<Speciality> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("speciality");
        mav.addObject("specialities", list);

        return mav;
    }


    @GetMapping(value = "/speciality/edit")
    private ModelAndView edit(@RequestParam(value = "id") Long id) {

        ModelAndView mav = new ModelAndView();

        Optional<Speciality> optional = this.service.findById(id);
        if (optional.isPresent()) {

            SpecialityForm form = new SpecialityForm(optional.get());
            mav.addObject("faculties", this.facultyService.findAll());
            mav.setViewName("speciality_edit");
            mav.addObject("specialityForm", form);
        } else {
            List<Speciality> list = this.service.findAll();
            mav.setViewName("speciality");
            mav.addObject("faculties", this.facultyService.findAll());
            mav.addObject("specialities", list);
        }

        return mav;
    }

    @PostMapping(value = "/speciality/save")
    private String save(SpecialityForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/edit";
        }

        Optional<Speciality> optional = null;
        if (form.getId() == null || form.getId().isEmpty()) {
            optional = Optional.empty();
        } else {
            optional = this.service.findById(Long.valueOf(form.getId()));
        }

        Optional<Faculty> faculty = this.facultyService
                .findById(form.getFacultyId());
        if (faculty.isPresent()) {
            form.setFacultyName(faculty.get().getFacultyName());
        }


        Speciality speciality1 = null;
        if (optional.isPresent()) {
            speciality1 = optional.get();
            speciality1.update(form);
        } else {
            speciality1 = new Speciality(form);
        }


        this.service.save(speciality1);

        return "redirect:/speciality";
    }

    @GetMapping(value = "/speciality/add")
    private ModelAndView add() {

        ModelAndView mav = new ModelAndView();
        SpecialityForm form = new SpecialityForm();



        mav.setViewName("speciality_edit");
        mav.addObject("faculties", this.facultyService.findAll());
        mav.addObject("specialityForm", form);

        return mav;
    }


    @GetMapping(value = "/speciality/delete")
    private ModelAndView delete(@RequestParam(value = "id") Long id) {

        this.service.delete(id);
        List<Speciality> list = this.service.findAll();


        ModelAndView mav = new ModelAndView();
        mav.setViewName("speciality");
        mav.addObject("specialities", list);

        return mav;
    }
}

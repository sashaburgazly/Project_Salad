package sasha.burgazli.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sasha.burgazli.App.models.StudyPlan;
import sasha.burgazli.App.models.form.StudyPlanForm;
import sasha.burgazli.App.service.StudyPlanService;

import java.util.List;
import java.util.Optional;

@Controller
public class StudyPlanController {

    private final StudyPlanService service;

    public StudyPlanController(StudyPlanService service) {
        this.service = service;
    }


    @GetMapping(value = "/studyplan")
    private ModelAndView studyplan() {

        List<StudyPlan> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("studyplan");
        mav.addObject("studyplans", list);

        return mav;
    }


    @GetMapping(value = "/studyplan/edit")
    private ModelAndView edit(@RequestParam(value = "id") Long id) {

        ModelAndView mav = new ModelAndView();

        Optional<StudyPlan> optional = this.service.findById(id);
        if (optional.isPresent()) {

            StudyPlanForm form = new StudyPlanForm(optional.get());

            mav.setViewName("studyplan_edit");
            mav.addObject("studyplanForm", form);
        } else {
            List<StudyPlan> list = this.service.findAll();
            mav.setViewName("studyplan");
            mav.addObject("studyplans", list);
        }

        return mav;
    }

    @PostMapping(value = "/studyplan/save")
    private String save(StudyPlanForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/edit";
        }

        Optional<StudyPlan> optional = null;
        if(form.getId() == null || form.getId().isEmpty()){
            optional = Optional.empty();
        }else {
            optional = this.service.findById(Long.valueOf(form.getId()));
        }


        StudyPlan studyplan1 = null;
        if (optional.isPresent()) {
            studyplan1 = optional.get();
            studyplan1.update(form);
        } else {
            studyplan1 = new StudyPlan(form);
        }


        this.service.save(studyplan1);

        return "redirect:/studyplan";
    }

    @GetMapping(value = "/studyplan/add")
    private ModelAndView add() {

        ModelAndView mav = new ModelAndView();
        StudyPlanForm form = new StudyPlanForm();

        mav.setViewName("studyplan_edit");
        mav.addObject("studyplanForm", form);

        return mav;
    }


    @GetMapping(value = "/studyplan/delete")
    private ModelAndView delete(@RequestParam(value = "id") Long id) {

        this.service.delete(id);
        List<StudyPlan> list = this.service.findAll();


        ModelAndView mav = new ModelAndView();
        mav.setViewName("studyplan");
        mav.addObject("studyplans", list);

        return mav;
    }
}

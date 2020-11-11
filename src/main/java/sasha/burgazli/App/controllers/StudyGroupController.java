package sasha.burgazli.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sasha.burgazli.App.models.StudyGroup;
import sasha.burgazli.App.models.form.StudyGroupForm;
import sasha.burgazli.App.service.StudyGroupService;

import java.util.List;
import java.util.Optional;

@Controller
public class StudyGroupController {

    private final StudyGroupService service;

    public StudyGroupController(StudyGroupService service) {
        this.service = service;
    }


    @GetMapping(value = "/studygroup")
    private ModelAndView studygroup() {

        List<StudyGroup> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("studygroup");
        mav.addObject("studygroups", list);

        return mav;
    }


    @GetMapping(value = "/studygroup/edit")
    private ModelAndView edit(@RequestParam(value = "id") Long id) {

        ModelAndView mav = new ModelAndView();

        Optional<StudyGroup> optional = this.service.findById(id);
        if (optional.isPresent()) {

            StudyGroupForm form = new StudyGroupForm(optional.get());

            mav.setViewName("studygroup_edit");
            mav.addObject("studygroupForm", form);
        } else {
            List<StudyGroup> list = this.service.findAll();
            mav.setViewName("studygroup");
            mav.addObject("studygroups", list);
        }

        return mav;
    }

    @PostMapping(value = "/studygroup/save")
    private String save(StudyGroupForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/edit";
        }

        Optional<StudyGroup> optional = null;
        if(form.getId() == null || form.getId().isEmpty()){
            optional = Optional.empty();
        }else {
            optional = this.service.findById(Long.valueOf(form.getId()));
        }


        StudyGroup studygroup1 = null;
        if (optional.isPresent()) {
            studygroup1 = optional.get();
            studygroup1.update(form);
        } else {
            studygroup1 = new StudyGroup(form);
        }


        this.service.save(studygroup1);

        return "redirect:/studygroup";
    }

    @GetMapping(value = "/studygroup/add")
    private ModelAndView add() {

        ModelAndView mav = new ModelAndView();
        StudyGroupForm form = new StudyGroupForm();

        mav.setViewName("studygroup_edit");
        mav.addObject("studygroupForm", form);

        return mav;
    }


    @GetMapping(value = "/studygroup/delete")
    private ModelAndView delete(@RequestParam(value = "id") Long id) {

        this.service.delete(id);
        List<StudyGroup> list = this.service.findAll();


        ModelAndView mav = new ModelAndView();
        mav.setViewName("studygroup");
        mav.addObject("studygroups", list);

        return mav;
    }
}

package sasha.burgazli.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sasha.burgazli.App.models.Discipline;
import sasha.burgazli.App.models.form.DisciplineForm;
import sasha.burgazli.App.service.DisciplineService;

import java.util.List;
import java.util.Optional;

@Controller
public class DisciplineController {

    private final DisciplineService service;

    public DisciplineController(DisciplineService service) {
        this.service = service;
    }


    @GetMapping(value = "/discipline")
    private ModelAndView discipline() {

        List<Discipline> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("discipline");
        mav.addObject("disciplines", list);

        return mav;
    }


    @GetMapping(value = "/discipline/edit")
    private ModelAndView edit(@RequestParam(value = "id") Long id) {

        ModelAndView mav = new ModelAndView();

        Optional<Discipline> optional = this.service.findById(id);
        if (optional.isPresent()) {

            DisciplineForm form = new DisciplineForm(optional.get());

            mav.setViewName("discipline_edit");
            mav.addObject("disciplineForm", form);
        } else {
            List<Discipline> list = this.service.findAll();
            mav.setViewName("discipline");
            mav.addObject("disciplines", list);
        }

        return mav;
    }

    @PostMapping(value = "/discipline/save")
    private String save(DisciplineForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/edit";
        }

        Optional<Discipline> optional = null;
        if(form.getId() == null || form.getId().isEmpty()){
            optional = Optional.empty();
        }else {
            optional = this.service.findById(Long.valueOf(form.getId()));
        }


        Discipline discipline1 = null;
        if (optional.isPresent()) {
            discipline1 = optional.get();
            discipline1.update(form);
        } else {
            discipline1 = new Discipline(form);
        }


        this.service.save(discipline1);

        return "redirect:/discipline";
    }

    @GetMapping(value = "/discipline/add")
    private ModelAndView add() {

        ModelAndView mav = new ModelAndView();
        DisciplineForm form = new DisciplineForm();

        mav.setViewName("discipline_edit");
        mav.addObject("disciplineForm", form);

        return mav;
    }


    @GetMapping(value = "/discipline/delete")
    private ModelAndView delete(@RequestParam(value = "id") Long id) {

        this.service.delete(id);
        List<Discipline> list = this.service.findAll();


        ModelAndView mav = new ModelAndView();
        mav.setViewName("discipline");
        mav.addObject("disciplines", list);

        return mav;
    }
}

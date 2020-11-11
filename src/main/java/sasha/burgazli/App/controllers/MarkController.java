package sasha.burgazli.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sasha.burgazli.App.models.Mark;
import sasha.burgazli.App.models.Speciality;
import sasha.burgazli.App.models.form.MarkForm;
import sasha.burgazli.App.service.MarkService;

import java.util.List;
import java.util.Optional;

@Controller
public class MarkController {

    private final MarkService service;

    public MarkController(MarkService service) {
        this.service = service;
    }


    @GetMapping(value = "/mark")
    private ModelAndView mark() {

        List<Mark> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("mark");
        mav.addObject("marks", list);

        return mav;
    }


    @GetMapping(value = "/mark/edit")
    private ModelAndView edit(@RequestParam(value = "id") Long id) {

        ModelAndView mav = new ModelAndView();

        Optional<Mark> optional = this.service.findById(id);
        if (optional.isPresent()) {

            MarkForm form = new MarkForm(optional.get());

            mav.setViewName("mark_edit");
            mav.addObject("markForm", form);
        } else {
            List<Mark> list = this.service.findAll();
            mav.setViewName("mark");
            mav.addObject("marks", list);
        }

        return mav;
    }

    @PostMapping(value = "/mark/save")
    private String save(MarkForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/edit";
        }

        Optional<Mark> optional = null;
        if(form.getId() == null || form.getId().isEmpty()){
            optional = Optional.empty();
        }else {
            optional = this.service.findById(Long.valueOf(form.getId()));
        }


        Mark mark1 = null;
        if (optional.isPresent()) {
            mark1 = optional.get();
            mark1.update(form);
        } else {
            mark1 = new Mark(form);
        }


        this.service.save(mark1);

        return "redirect:/mark";
    }

    @GetMapping(value = "/mark/add")
    private ModelAndView add() {

        ModelAndView mav = new ModelAndView();
        MarkForm form = new MarkForm();

        mav.setViewName("mark_edit");
        mav.addObject("markForm", form);

        return mav;
    }


    @GetMapping(value = "/mark/delete")
    private ModelAndView delete(@RequestParam(value = "id") Long id) {

        this.service.delete(id);
        List<Mark> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("mark");
        mav.addObject("marks", list);

        return mav;
    }
}

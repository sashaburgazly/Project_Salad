package sasha.burgazli.App.controllers;

import org.aspectj.apache.bcel.generic.FieldOrMethod;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sasha.burgazli.App.models.Student;
import sasha.burgazli.App.models.form.StudentForm;
import sasha.burgazli.App.service.StudentService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }


    @GetMapping(value = "/student")
    private ModelAndView student() {

        List<Student> list = this.service.findAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("student");
        mav.addObject("students", list);

        return mav;
    }


    @GetMapping(value = "/student/edit")
    private ModelAndView edit(@RequestParam(value = "id") Long id) {

        ModelAndView mav = new ModelAndView();

        Optional<Student> optional = this.service.findById(id);
        if (optional.isPresent()) {

            StudentForm form = new StudentForm(optional.get());

            mav.setViewName("student_edit");
            mav.addObject("studentForm", form);
        } else {
            List<Student> list = this.service.findAll();
            mav.setViewName("student");
            mav.addObject("students", list);
        }

        return mav;
    }

    @PostMapping(value = "/student/save")
    private String save(StudentForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/edit";
        }

        Optional<Student> optional = null;
        if(form.getId() == null || form.getId().isEmpty()){
            optional = Optional.empty();
        }else {
            optional = this.service.findById(Long.valueOf(form.getId()));
        }


        Student student1 = null;
        if (optional.isPresent()) {
            student1 = optional.get();
            student1.update(form);
        } else {
            student1 = new Student(form);
        }


        this.service.save(student1);

        return "redirect:/student";
    }

    @GetMapping(value = "/student/add")
    private ModelAndView add() {



        ModelAndView mav = new ModelAndView();
        StudentForm form = new StudentForm();

        mav.setViewName("student_edit");
        mav.addObject("studentForm", form);

        return mav;
    }


    @GetMapping(value = "/student/delete")
    private ModelAndView delete(@RequestParam(value = "id") Long id) {

        this.service.delete(id);
        List<Student> list = this.service.findAll();


        ModelAndView mav = new ModelAndView();
        mav.setViewName("student");
        mav.addObject("students", list);

        return mav;
    }
}

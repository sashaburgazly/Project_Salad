package sasha.burgazli.App.models.form;

import sasha.burgazli.App.models.Discipline;

import java.text.ParseException;
import java.util.Date;


public class DisciplineForm {

    private String id;

    public String disciplineName;
    public String disciplineTeacher;
    public Integer percentageOfVisit;

    public DisciplineForm() {

    }

    public DisciplineForm(Discipline discipline) {
        this.id = String.valueOf(discipline.getId());
        this.disciplineName = String.valueOf(discipline.getDisciplineName());
        this.disciplineTeacher = String.valueOf(discipline.getDisciplineTeacher());
        this.percentageOfVisit = Integer.valueOf(discipline.getPercentageOfVisit());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisciplineName() {return disciplineName;}

    public void setDisciplineName(String disciplineName) {this.disciplineName = disciplineName;}

    public String getDisciplineTeacher() {return disciplineTeacher;}

    public void setDisciplineTeacher(String disciplineTeacher) {this.disciplineTeacher = disciplineTeacher;}

    public Integer getPercentageOfVisit() {return percentageOfVisit;}
    public void setPercentageOfVisit(Integer percentageOfVisit) { this.percentageOfVisit = percentageOfVisit;}

}

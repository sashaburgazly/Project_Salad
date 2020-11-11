package sasha.burgazli.App.models;

import sasha.burgazli.App.models.form.DisciplineForm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "discipline")
public class Discipline{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "disciplineName")
    private String disciplineName;

    @Column(name = "disciplineTeacher")
    private String disciplineTeacher;

    @Column(name = "percentageOfVisit")
    private Integer percentageOfVisit;

    private Discipline() {

    }

    public Discipline(DisciplineForm form) {
        this.update(form);
    }

    public Long getId() {
        return id;
    }

    public String getDisciplineName() {return disciplineName;}

    public void setDisciplineName(String disciplineName) {this.disciplineName = disciplineName;}

    public String getDisciplineTeacher() {return disciplineTeacher;}

    public void setDisciplineTeacher(String disciplineTeacher) {this.disciplineTeacher = disciplineTeacher;}

    public Integer getPercentageOfVisit() {return percentageOfVisit;}

    public void setPercentageOfVisit(Integer percentageOfVisit) {this.percentageOfVisit = percentageOfVisit;}


    public void update(DisciplineForm form) {
        this.disciplineName = form.getDisciplineName();
        this.disciplineTeacher = form.getDisciplineTeacher();
        this.percentageOfVisit = form.getPercentageOfVisit();
    }
}

package sasha.burgazli.App.models;

import sasha.burgazli.App.models.form.StudyPlanForm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "studyplan")
public class StudyPlan{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "specialityName")
    private String specialityName;

    @Column(name = "studyYear")
    private Integer studyYear;

    @Column(name = "courseValue")
    private Integer courseValue;

    @Column(name = "startSemesterNumber")
    private Date startSemesterNumber;

    @Column(name = "finishSemesterNumber")
    private Date finishSemesterNumber;

    @Column(name = "disciplineName")
    private String disciplineName;

    @Column(name = "numberOfHours")
    private Integer numberOfHours;

    private StudyPlan() {

    }

    public StudyPlan(StudyPlanForm form) {this.update(form);}

    public Long getId() {
        return id;
    }

    public String getSpecialityName() {return specialityName;}

    public void setSpecialityName(String specialityName) {this.specialityName = specialityName;}

    public Integer getStudyYear(){return studyYear;}

    public void setStudyYear(Integer studyYear){this.studyYear=studyYear;}

    public Integer getCourseValue() {return courseValue;}

    public void setCourseValue(Integer courseValue) {this.courseValue = courseValue;}

    public Date getStartSemesterNumber() {return startSemesterNumber;}

    public void setStartSemesterNumber(Date startSemesterNumber) {this.startSemesterNumber = startSemesterNumber;}

    public Date getFinishSemesterNumber() {return finishSemesterNumber;}

    public void setFinishSemesterNumber(Date finishSemesterNumber) {this.finishSemesterNumber = finishSemesterNumber;}

    public String getDisciplineName() {return disciplineName;}

    public void setDisciplineName(String disciplineName) {this.disciplineName = disciplineName;}

    public Integer getNumberOfHours() {return numberOfHours;}

    public void setNumberOfHours(Integer numberOfHours) {this.numberOfHours = numberOfHours;}

    public void update(StudyPlanForm form) {
        this.specialityName = form.getSpecialityName();
        this.studyYear = form.getStudyYear();
        this.courseValue = form.getCourseValue();
        this.startSemesterNumber = form.getStartSemesterNumber();
        this.finishSemesterNumber = form.getFinishSemesterNumber();
        this.disciplineName = form.getDisciplineName();
        this.numberOfHours = form.getNumberOfHours();

    }
}

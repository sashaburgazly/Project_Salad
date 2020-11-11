package sasha.burgazli.App.models;

import sasha.burgazli.App.models.form.StudyGroupForm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "studygroup")
public class StudyGroup{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "groupNumber")
    private Integer groupNumber;

    @Column(name = "courseValue")
    private Integer courseValue;

    @Column(name = "specialityName")
    private String specialityName;

    private StudyGroup() {

    }

    public StudyGroup(StudyGroupForm form) {
        this.update(form);
    }

    public Long getId() {
        return id;
    }

    public Integer getGroupNumber() {return groupNumber;}

    public void setGroupNumber(Integer groupNumber) {this.groupNumber= groupNumber;}

    public Integer getCourseValue() {return courseValue;}

    public void setCourseValue(Integer courseValue) {this.courseValue = courseValue;}

    public String getSpecialityName() {return specialityName;}

    public void setSpecialityName(String specialityName) {this.specialityName = specialityName;}

    public void update(StudyGroupForm form) {
        this.groupNumber = form.getGroupNumber();
        this.courseValue = form.getCourseValue();
        this.specialityName = form.getSpecialityName();
    }
}

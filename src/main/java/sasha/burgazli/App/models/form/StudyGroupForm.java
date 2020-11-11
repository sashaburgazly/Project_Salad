package sasha.burgazli.App.models.form;

import sasha.burgazli.App.models.StudyGroup;


public class StudyGroupForm {


    private String id;

    private Integer groupNumber;
    private Integer courseValue;
    private String specialityName;

    public StudyGroupForm() {

    }

    public StudyGroupForm(StudyGroup studygroup) {
        this.id = String.valueOf(studygroup.getId());
        this.groupNumber = Integer.valueOf(studygroup.getGroupNumber());
        this.courseValue = Integer.valueOf(studygroup.getCourseValue());
        this.specialityName = String.valueOf(studygroup.getSpecialityName());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

    public Integer getGroupNumber() {return groupNumber;}

    public void setGroupNumber(Integer groupNumber) {this.groupNumber= groupNumber;}

    public Integer getCourseValue() {return courseValue;}

    public void setCourseValue(Integer courseValue) {this.courseValue = courseValue;}

    public String getSpecialityName() {return specialityName;}

    public void setSpecialityName(String specialityName) {this.specialityName = specialityName;}


}

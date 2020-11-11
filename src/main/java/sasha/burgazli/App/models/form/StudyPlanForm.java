package sasha.burgazli.App.models.form;

import sasha.burgazli.App.models.StudyPlan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StudyPlanForm {

    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private String id;

    private String specialityName;
    private Integer studyYear;
    private Integer courseValue;
    private Date startSemesterNumber;
    private Date finishSemesterNumber;
    private String disciplineName;
    private Integer numberOfHours;

    public StudyPlanForm() {

    }

    public StudyPlanForm(StudyPlan studyplan) {
        this.id = String.valueOf(studyplan.getId());
        this.specialityName = String.valueOf(studyplan.getSpecialityName());
        this.studyYear = Integer.valueOf(studyplan.getStudyYear());
        this.courseValue = Integer.valueOf(studyplan.getCourseValue());
        this.disciplineName = String.valueOf(studyplan.getDisciplineName());
        this.numberOfHours = Integer.valueOf(studyplan.getNumberOfHours());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

    public String getSpecialityName() {return specialityName;}

    public void setSpecialityName(String specialityName) {this.specialityName = specialityName;}

    public Integer getStudyYear(){return studyYear;}

    public void setStudyYear(Integer studyYear){this.studyYear=studyYear;}

    public Integer getCourseValue() {return courseValue;}

    public void setCourseValue(Integer courseValue) {this.courseValue = courseValue;}

    public Date getStartSemesterNumber() {return startSemesterNumber;}

    public void setStartSemesterNumber(String startSemesterNumber) {
        try {
            this.startSemesterNumber = SIMPLE_DATE_FORMAT.parse(startSemesterNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getFinishSemesterNumber() {return finishSemesterNumber;}

    public void setFinishSemesterNumber(String finishSemesterNumber) {
        try {
            this.startSemesterNumber = SIMPLE_DATE_FORMAT.parse(finishSemesterNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDisciplineName() {return disciplineName;}

    public void setDisciplineName(String disciplineName) {this.disciplineName = disciplineName;}

    public Integer getNumberOfHours() {return numberOfHours;}

    public void setNumberOfHours(Integer numberOfHours) {this.numberOfHours = numberOfHours;}

}

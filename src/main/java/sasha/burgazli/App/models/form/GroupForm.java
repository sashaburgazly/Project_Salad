package sasha.burgazli.App.models.form;

import sasha.burgazli.App.models.Group;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GroupForm {

    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private String id;

    public Integer studyYear;
    public Date startSemesterNumber;
    public Date finishSemesterNumber;
    public String studentLastName;
    public Integer groupNumber;

    public GroupForm() {

    }

    public GroupForm(Group group) {
        this.id = String.valueOf(group.getId());
        this.studyYear= group.getStudyYear();
        this.studentLastName=String.valueOf(group.getStudentLastName());
        this.groupNumber= group.getGroupNumber();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

    public Integer getStudyYear(){return studyYear;}

    public void setStudyYear(Integer studyYear){this.studyYear=studyYear;}

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
            this.finishSemesterNumber = SIMPLE_DATE_FORMAT.parse(finishSemesterNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getStudentLastName(){return studentLastName;}

    public void setStudentLastName(String studentLastName){this.studentLastName=studentLastName;}

    public Integer getGroupNumber(){return groupNumber;}

    public void setGroupNumber(Integer groupNumber){this.groupNumber=groupNumber;}

}

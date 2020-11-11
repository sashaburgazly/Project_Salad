package sasha.burgazli.App.models.form;

import sasha.burgazli.App.models.Mark;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MarkForm {

    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private String id;

    public Integer studyYear;
    public Date startSemesterNumber;
    public Date finishSemesterNumber;
    public String studentLastName;
    public String disciplineName;
    public Integer markValue;

    public MarkForm() {

    }

    public MarkForm(Mark mark) {
        this.id = String.valueOf(mark.getId());
        this.studyYear=Integer.valueOf(mark.getStudyYear());
        this.studentLastName=String.valueOf(mark.getStudentLastName());
        this.disciplineName=String.valueOf(mark.getDisciplineName());
        this.markValue=Integer.valueOf(mark.getMarkValue());

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

    public String getDisciplineName(){return disciplineName;}

    public void setDisciplineName(String disciplineName){this.disciplineName=disciplineName;}

    public Integer getMarkValue(){return markValue;}

    public void setMarkValue(Integer markValue){this.markValue=markValue;}

}

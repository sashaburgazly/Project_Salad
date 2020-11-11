package sasha.burgazli.App.models.form;

import sasha.burgazli.App.models.Semester;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SemesterForm {

    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private String id;

    public Date startSemesterNumber;
    public Date finishSemesterNumber;
    public Integer sessionSuccess;

    public SemesterForm() {

    }

    public SemesterForm(Semester semester) {
        this.id = String.valueOf(semester.getId());
        this.sessionSuccess = Integer.valueOf(semester.getSessionSuccess());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

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

    public Integer getSessionSuccess() {return sessionSuccess;}
    public void setSessionSuccess(Integer sessionSuccess) { this.sessionSuccess = sessionSuccess;}

}

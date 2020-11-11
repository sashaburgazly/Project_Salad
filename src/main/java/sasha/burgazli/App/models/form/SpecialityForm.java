package sasha.burgazli.App.models.form;

import sasha.burgazli.App.models.Speciality;
import sasha.burgazli.App.models.Faculty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SpecialityForm {


    private String id;

    public String facultyName;
    public String specialityName;

    public SpecialityForm() {

    }

    public SpecialityForm(Speciality speciality) {
        this.id = String.valueOf(speciality.getId());
        this.facultyName = String.valueOf(speciality.getFacultyName());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

    public String getFacultyName() {return facultyName;}

    public void setFacultyName(String facultyName) {
            this.facultyName = facultyName;
    }

    public String getSpecialityName() {return specialityName;}

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;

    }

}

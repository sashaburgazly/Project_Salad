package sasha.burgazli.App.models.form;

import sasha.burgazli.App.models.Speciality;
import sasha.burgazli.App.models.Faculty;

import javax.persistence.Transient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SpecialityForm {


    private String id;

    private Long facultyId;
    private String specialityName;

    @Transient
    private transient String facultyName;

    public SpecialityForm() {

    }

    public SpecialityForm(Speciality speciality) {
        this.id = String.valueOf(speciality.getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;

    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}

package sasha.burgazli.App.models;

import sasha.burgazli.App.models.form.SpecialityForm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "speciality")
public class Speciality{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "facultyName")
    private String facultyName;

    @Column(name = "specialityName")
    private String specialityName;

    private Speciality() {

    }

    public Speciality(SpecialityForm form) {
        this.update(form);
    }

    public Long getId() {
        return id;
    }

    public String getFacultyName() {return facultyName;}

    public void setFacultyName(String facultyName) {this.facultyName= facultyName;}

    public String getSpecialityName() {return specialityName;}

    public void setSpecialityName(String specialityName) {this.specialityName = specialityName;}

    public void update(SpecialityForm form) {
        this.facultyName = form.getFacultyName();
        this.specialityName = form.getSpecialityName();
    }
}

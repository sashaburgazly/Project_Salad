package sasha.burgazli.App.models;

import sasha.burgazli.App.models.form.StudentForm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "fathername")
    private String fatherName;

    @Column(name = "date")
    private Date date;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    private Student() {

    }

    public Student(StudentForm form) {
       this.update(form);
    }


    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void update(StudentForm form) {
        this.firstName = form.getFirstName();
        this.lastName = form.getLastName();
        this.fatherName = form.getFatherName();
        this.date = form.getDate();
        this.address = form.getAddress();
        this.phone = form.getPhone();
    }
}

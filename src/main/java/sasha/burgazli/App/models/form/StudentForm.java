package sasha.burgazli.App.models.form;

import sasha.burgazli.App.models.Student;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentForm {

    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private String id;

    private String lastName;

    private String firstName;

    private String fatherName;

    private Date date;

    private String address;

    private String phone;

    public StudentForm() {

    }

    public StudentForm(Student student) {
        this.id = String.valueOf(student.getId());
        this.lastName = student.getLastName();
        this.firstName = student.getFirstName();
        this.fatherName = student.getFatherName();
//        this.date = student.getDate();
//        this.address = student.getAddress();
//        this.phone = student.getPhone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setDate(String date) {
        try {
            this.date = SIMPLE_DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
}

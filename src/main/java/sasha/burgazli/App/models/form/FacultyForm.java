package sasha.burgazli.App.models.form;

import sasha.burgazli.App.models.Faculty;


public class FacultyForm {

    private String id;

    public String facultyName;
    private String address;
    private String deanFio;
    private String methodistFio;
    private String email;
    private Integer cathedraAmount;
    private Integer professorAmount;
    private Integer studentAmount;

    public FacultyForm() {

    }

    public FacultyForm(Faculty faculty) {
        this.id = String.valueOf(faculty.getId());
        this.facultyName = faculty.getFacultyName();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacultyName() {return facultyName;}

    public void setFacultyName(String facultyName) {
        this.facultyName=facultyName;
    }

    public String getAddress(){return address;}

    public void setAddress(String address) {this.address = address;}

    public String getDeanFio(){return deanFio;}

    public void setDeanFio(String deanFio) {this.deanFio = deanFio;}

    public String getMethodistFio(){return methodistFio;}

    public void setMethodistFio(String methodistFio) {this.methodistFio = methodistFio;}

    public String getEmail(){return email;}

    public void setEmail(String email) {this.email = email;}

    public Integer getCathedraAmount(){return cathedraAmount;}

    public void setCathedraAmount(Integer cathedraAmount) {this.cathedraAmount = cathedraAmount;}

    public Integer getProfessorAmount(){return professorAmount;}

    public void setProfessorAmount(Integer professorAmount) {this.professorAmount = professorAmount;}

    public Integer getStudentAmount(){return studentAmount;}

    public void setStudentAmount(Integer studentAmount) {this.studentAmount = studentAmount;}

}

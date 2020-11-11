package sasha.burgazli.App.models;

import sasha.burgazli.App.models.form.FacultyForm;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "faculty")
public class Faculty{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "facultyName")
    public String facultyName;

    @Column(name = "address")
    private String address;

    @Column(name = "deanFio")
    private String deanFio;

    @Column(name = "methodistFio")
    private String methodistFio;

    @Column(name = "email")
    private String email;

    @Column(name = "cathedraAmount")
    private Integer cathedraAmount;

    @Column(name = "professorAmount")
    private Integer professorAmount;

    @Column(name = "studentAmount")
    private Integer studentAmount;

    protected Faculty() {

    }

    public Faculty(FacultyForm form) {
        this.update(form);
    }

    public Long getId() {
        return id;
    }

    public String getFacultyName() {return facultyName;}

    public void setFacultyName(String facultyName) {this.facultyName = facultyName;}

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

    public void update(FacultyForm form) {
        this.facultyName = form.getFacultyName();
        this.address = form.getAddress();
        this.deanFio = form.getDeanFio();
        this.methodistFio = form.getMethodistFio();
        this.email = form.getEmail();
        this.cathedraAmount = form.getCathedraAmount();
        this.professorAmount = form.getProfessorAmount();
        this.studentAmount = form.getStudentAmount();
    }
}

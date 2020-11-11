package sasha.burgazli.App.models;

import sasha.burgazli.App.models.form.MarkForm;
import sasha.burgazli.App.models.form.SemesterForm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "mark")
public class Mark{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "studyYear")
    private Integer studyYear;

    @Column(name = "startSemesterNumber")
    private Date startSemesterNumber;

    @Column(name = "finishSemesterNumber")
    private Date finishSemesterNumber;

    @Column(name = "studentLastName")
    private String studentLastName;

    @Column(name = "disciplineName")
    private String disciplineName;

    @Column(name = "markValue")
    private Integer markValue;


    private Mark() {

    }

    public Mark(MarkForm form) {
        this.update(form);
    }

    public Long getId() {
        return id;
    }

    public Integer getStudyYear(){return studyYear;}

    public void setStudyYear(Integer studyYear){this.studyYear=studyYear;}

    public Date getStartSemesterNumber(){return startSemesterNumber;}

    public void setStartSemesterNumber(Date startSemesterNumber){this.startSemesterNumber=startSemesterNumber;}

    public Date getFinishSemesterNumber() {return finishSemesterNumber;}

    public void setFinishSemesterNumber(Date finishSemesterNumber) {this.finishSemesterNumber = finishSemesterNumber;}

    public String getStudentLastName(){return studentLastName;}

    public void setStudentLastName(String studentLastName){this.studentLastName=studentLastName;}

    public String getDisciplineName(){return disciplineName;}

    public void setDisciplineName(String disciplineName){this.disciplineName=disciplineName;}

    public Integer getMarkValue(){return markValue;}

    public void setMarkValue(Integer markValue){this.markValue=markValue;}

    public void update(MarkForm form) {
        this.studyYear = form.getStudyYear();
        this.startSemesterNumber = form.getStartSemesterNumber();
        this.finishSemesterNumber = form.getFinishSemesterNumber();
        this.studentLastName = form.getStudentLastName();
        this.disciplineName = form.getDisciplineName();
        this.markValue = form.getMarkValue();
    }
}

package sasha.burgazli.App.models;

import sasha.burgazli.App.models.form.GroupForm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "group")
public class Group{

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

    @Column(name = "groupNumber")
    private Integer groupNumber;


    private Group() {

    }

    public Group(GroupForm form) {
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

    public Integer getGroupNumber(){return groupNumber;}

    public void setGroupNumber(Integer groupNumber){this.groupNumber=groupNumber;}

    public void update(GroupForm form) {
        this.studyYear = form.getStudyYear();
        this.startSemesterNumber = form.getStartSemesterNumber();
        this.finishSemesterNumber = form.getFinishSemesterNumber();
        this.studentLastName = form.getStudentLastName();
        this.groupNumber = form.getGroupNumber();
    }
}

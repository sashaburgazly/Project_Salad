package sasha.burgazli.App.models;

import sasha.burgazli.App.models.form.SemesterForm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "marks")
public class Mark{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "startSemesterNumber")
    private Date startSemesterNumber;

    @Column(name = "finishSemesterNumber")
    private Date finishSemesterNumber;

    @Column(name = "sessionSuccess")
    private Integer sessionSuccess;

    private Semester() {

    }

    public Semester(SemesterForm form) {
        this.update(form);
    }

    public Long getId() {
        return id;
    }

    public Date getFinishSemesterNumber() {return finishSemesterNumber;}

    public void setFinishSemesterNumber(Date finishSemesterNumber) {this.finishSemesterNumber = finishSemesterNumber;}

    public Date getStartSemesterNumber() {return startSemesterNumber;}

    public void setStartSemesterNumber(Date startSemesterNumber) {this.startSemesterNumber = startSemesterNumber;}

    public Integer getSessionSuccess() {return sessionSuccess;}

    public void setSessionSuccess(Integer sessionSuccess) {this.sessionSuccess = sessionSuccess;}


    public void update(SemesterForm form) {
        this.startSemesterNumber = form.getStartSemesterNumber();
        this.finishSemesterNumber = form.getFinishSemesterNumber();
        this.sessionSuccess = form.getSessionSuccess();
    }
}

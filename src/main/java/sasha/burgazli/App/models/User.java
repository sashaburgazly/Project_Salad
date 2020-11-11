package sasha.burgazli.App.models;

import sasha.burgazli.App.models.form.DisciplineForm;
import sasha.burgazli.App.models.form.UserForm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    private User() {

    }

    public User(UserForm form) {
        this.update(form);
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {return login;}

    public void setLogin(String login) {this.login = login;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}


    public void update(UserForm form) {
        this.login = form.getLogin();
        this.password = form.getPassword();
        this.role = form.getRole();
    }
}

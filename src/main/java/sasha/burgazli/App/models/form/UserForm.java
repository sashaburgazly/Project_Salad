package sasha.burgazli.App.models.form;

import sasha.burgazli.App.models.User;


public class UserForm {

    private String id;

    public String login;
    public String password;
    public String  role;

    public UserForm() {

    }

    public UserForm(User user) {
        this.id = String.valueOf(user.getId());
        this.login = String.valueOf(user.getLogin());
        this.password = String.valueOf(user.getPassword());
        this.role = String.valueOf(user.getRole());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {return login;}

    public void setLogin(String login) {this.login = login;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getRole() {return role;}

    public void setRole(String role) { this.role = role;}

}

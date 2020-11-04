package sasha.burgazli.App.models;

import sasha.burgazli.App.models.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(schema = "public", name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "privilege")
    private Long privilege;



}

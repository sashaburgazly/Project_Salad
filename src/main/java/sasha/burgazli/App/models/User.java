package sasha.burgazli.App.models;

import org.springframework.security.core.userdetails.UserDetails;
import sasha.burgazli.App.models.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(schema = "public", name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @Column(name = "privilege")
    private Long privilege;



}

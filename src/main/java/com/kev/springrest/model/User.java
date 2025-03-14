package com.kev.springrest.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name="lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name="email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name="password", nullable = false, length = 100)
    private String password;

    public User(){
    }

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email=" + email +
                '}';
    }

}

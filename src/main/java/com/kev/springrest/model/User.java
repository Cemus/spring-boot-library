package com.kev.springrest.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message="Un prénom est nécessaire !")
    @Column(name="firstname", nullable = false, length = 50)
    private String firstname;

    @NotBlank(message="Un nom est nécessaire !")
    @Column(name="lastname", nullable = false, length = 50)
    private String lastname;

    @NotBlank(message="Une adresse courriel est nécessaire !")
    @Email(message="Une adresse courriel valide est nécessaire !")
    @Column(name="email", nullable = false, length = 50, unique = true)
    private String email;


    @NotBlank(message="Un mot de passe est nécessaire !")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}$")
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

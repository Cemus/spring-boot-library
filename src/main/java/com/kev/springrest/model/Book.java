package com.kev.springrest.model;

import com.kev.springrest.validation.PastOrPresentYear;
import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Valid
    @NotBlank(message="Le livre doit avoir un titre")
    @Size(message="Minimum trois caractères pour le titre du livre",min=3)
    @Column(name="title", nullable = false, length = 50, unique = true)
    private String title;

    @NotBlank(message="Le livre doit avoir une description")
    @Size(message="Minimum cinq caractères pour la description du livre",min=5)
    @Column(name="description", nullable = false)
    private String description;

    @Column(name="publication_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @PastOrPresentYear(
            min= 1500,
            message= "La date de publication doit être comprise entre 1500 et l'année courante")
    private java.sql.Date publicationDate;


    @NotNull(message = "L'auteur ne doit pas être nul")
    @Column(name="author", length=50)
    private String author;

    @Getter
    @ManyToMany
    @Column(name="genre", length=50)
    @JoinTable( name = "book_genre",
            joinColumns = @JoinColumn( name = "id_book" ),
            inverseJoinColumns = @JoinColumn( name = "id_genre" )
    )
    private List<Genre> genres;

    @ManyToOne
    @JoinColumn(name = "id_publisher")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Book(){
        this.genres = new ArrayList<>();
    }

    public Book(String title, String description, Date publicationDate) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.genres = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titre='" + title + '\'' +
                ", description='" + description + '\'' +
                ", auteur='" + author + '\'' +
                ", genres='" + genres + '\'' +
                ", publicationDate=" + publicationDate +
                ", maison d'édition='" + publisher + '\'' +
                '}';
    }


}

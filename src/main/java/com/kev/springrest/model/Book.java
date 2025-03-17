package com.kev.springrest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
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
    @Min(message="Minimum trois caractères pour le titre du livre",value=3)
    @Column(name="title", nullable = false, length = 50, unique = true)
    private String title;

    @Valid
    @NotBlank(message="Le livre doit avoir une description")
    @Min(message="Minimum cinq caractères pour la description du livre",value=5)
    @Column(name="description", nullable = false)
    private String description;

    @Valid
    @Column(name="publication_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @Min(value=1800,message="La date doit être comprise entre 1800 et 2025")
    @Max(value=2025,message="La date doit être comprise entre 1800 et 2025")
    private java.util.Date publicationDate;

    @Valid
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

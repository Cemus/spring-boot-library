package com.kev.springrest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name="title", nullable = false, length = 50, unique = true)
    private String title;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="publication_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date publicationDate;

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
                ", genres='" + displayGenres() + '\'' +
                ", publicationDate=" + publicationDate +
                ", maison d'édition='" + publisher + '\'' +
                '}';
    }

    public String displayGenres(){
        String genreDisplay = "";
        genres.forEach(genre -> genreDisplay.concat(genre.getName() + " "));
        return genreDisplay;
    }
}

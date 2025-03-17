package com.kev.springrest.model;

import jakarta.persistence.*;
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

    @Column(name="title", nullable = false, length = 50, unique = true)
    private String title;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="publication_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date publicationDate;

    @Column(name="author", length=50)
    private String author;

    @ManyToMany
    @Column(name="genres", length=50)
    @JoinTable(name="book_genre")
    private List<Genre> genres;

    @ManyToOne
    @JoinColumn(name = "id_publisher")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Book(){

    }

    public Book(String title, String description, ArrayList<Genre> genres, String author, Date publicationDate, Publisher publisher) {
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.author = author;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
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

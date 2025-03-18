package com.kev.springrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(message="Minimum trois caractères pour le nom du genre",min=3)
    @NotBlank(message="Le genre doit avoir un nom")
    @Column(name = "name", nullable = false, length = 50, unique = true)
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
package com.kev.springrest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="label", nullable = false, length = 50, unique = true)
    private String label;

    @Column(name="description", nullable = false)
    private String description;


}

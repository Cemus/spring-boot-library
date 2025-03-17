package com.kev.springrest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Valid
    @NotBlank(message="Le libellé ne doit pas être vide")
    @Min(message="Deux caractères minimum",value=2)
    @Column(name="label", nullable = false, length = 50, unique = true)
    private String label;

    @Valid
    @NotNull(message="La description de la maison d'édition ne peut être nulle...")
    @Min(message="Cinq caractères minimum pour la maison d'édition", value= 5)
    @Column(name="description", nullable = false)
    private String description;


}

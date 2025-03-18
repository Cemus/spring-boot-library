package com.kev.springrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message="Le libellé ne doit pas être vide")
    @Size(message="Deux caractères minimum",min=2)
    @Column(name="label", nullable = false, length = 50, unique = true)
    private String label;

    @NotNull(message="La description de la maison d'édition ne peut être nulle...")
    @Size(message="Cinq caractères minimum pour la maison d'édition", min= 5)
    @Column(name="description", nullable = false)
    private String description;


}

package com.kev.springrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false, length = 50)
    @NotNull
    private String name;

    @Column(name="description", nullable = false, length = 50)
    @NotNull
    private String description;

    @Column(name="price", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;


    public Product() {
    }

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }



}
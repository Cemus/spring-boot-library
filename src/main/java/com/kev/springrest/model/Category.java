package com.kev.springrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="category")
public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(name="label", nullable = false, length = 50)
        @NotNull
        private String label;


        public Category() {
        }

    public Category(String label) {
                this.label = label;
    }

        @Override
        public String toString() {
            return "Catégorie{" +
                    "id=" + id +
                    ", label='" + label + '\'' +
                    '}';
        }


}

package com.kev.springrest.service;

import com.kev.springrest.model.Genre;
import com.kev.springrest.repository.GenreRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Data
@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public void saveGenre(final Genre genre) {
        Iterable<Genre>  genres= genreRepository.findAll();

        if (genre.getName() == null || genre.getName().isEmpty()){
            System.out.println("Problème de requête avec " + genre.getName());
        }

        for (Genre g : genres) {
            if (Objects.equals(g.getName(), genre.getName())){
                System.out.println(genre.getName() + "Existe déjà...");

            }
        }

        genreRepository.save(genre);
    }


}

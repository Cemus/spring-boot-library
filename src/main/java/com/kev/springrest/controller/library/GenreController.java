package com.kev.springrest.controller.library;

import com.kev.springrest.model.Genre;
import com.kev.springrest.service.library.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping("/genre")
    public Genre addGenre(@Validated @RequestBody Genre genre) {
        genreService.saveGenre(genre);
        return genre;
    }
}

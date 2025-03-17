package com.kev.springrest.dto;


import com.kev.springrest.model.Genre;

import java.util.Date;
import java.util.List;

public record BookDTO(long id, String title, String author, List<Genre> genres, Date publicationDate, String publisher) {
}

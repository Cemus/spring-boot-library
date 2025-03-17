package com.kev.springrest.dto;


import com.kev.springrest.model.Genre;

import java.util.ArrayList;
import java.util.Date;

public record BookDTO(long id, String title, String author, ArrayList<Genre> genres, Date publicationDate, String publisher) {
}

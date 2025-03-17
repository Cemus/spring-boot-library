package com.kev.springrest.dto;



import java.util.Date;


public record BookDTO(long id, String title, String author, String genres, Date publicationDate, String publisher) {
}

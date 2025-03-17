package com.kev.springrest.service;

import com.kev.springrest.dto.BookDTO;
import com.kev.springrest.model.Book;
import com.kev.springrest.model.Genre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookDTOWrapper {
    public BookDTO toDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                (ArrayList<Genre>) book.getGenres(),
                book.getPublicationDate(),
                book.getPublisher().getLabel()
        );
    }
}

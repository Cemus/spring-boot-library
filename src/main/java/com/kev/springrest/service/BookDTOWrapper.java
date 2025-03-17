package com.kev.springrest.service;

import com.kev.springrest.dto.BookDTO;
import com.kev.springrest.model.Book;
import com.kev.springrest.model.Genre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class BookDTOWrapper {
    public BookDTO toDTO(Book book) {
        String genres = "";

        for (Genre g : book.getGenres()) {
            genres += g.getName() + ", ";
        }
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                genres,
                book.getPublicationDate(),
                book.getPublisher().getLabel()
        );
    }
}

package com.kev.springrest.service;

import com.kev.springrest.dto.BookDTO;
import com.kev.springrest.model.Book;
import com.kev.springrest.model.Genre;
import org.springframework.stereotype.Service;



@Service
public class BookDTOWrapper {
    public BookDTO toDTO(Book book) {
        StringBuilder genres = new StringBuilder();

        for (Genre g : book.getGenres()) {
            genres.append(g.getName()).append(", ");
        }
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                genres.toString(),
                book.getPublicationDate(),
                book.getPublisher().getLabel()
        );
    }
}

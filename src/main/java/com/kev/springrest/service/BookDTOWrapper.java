package com.kev.springrest.service;

import com.kev.springrest.dto.BookDTO;
import com.kev.springrest.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookDTOWrapper {
    public BookDTO toDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationDate(),
                book.getPublisher().getLabel()
        );
    }
}

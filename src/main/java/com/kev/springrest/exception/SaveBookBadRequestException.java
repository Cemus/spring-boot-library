package com.kev.springrest.exception;

import com.kev.springrest.model.Book;

public class SaveBookBadRequestException extends RuntimeException {
    public SaveBookBadRequestException(Book book) {
        super("Le livre :" + book + "\n n'a pas les champs requis.");
    }

}

package com.kev.springrest.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(long id) {
        super("Le livre ("  + id + ") n'a pas été trouvé");
    }
}

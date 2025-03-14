package com.kev.springrest.exception;

public class BooksNotFoundException extends RuntimeException {
    public BooksNotFoundException() {
        super("Il n'y a aucun livre dans la bibliothèque...");
    }
}

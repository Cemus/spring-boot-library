package com.kev.springrest.exception;

public class PublisherExistsException extends RuntimeException {
    public PublisherExistsException(String label, long id) {
        super("La maison d'édition \"" + label + "\" existe déjà ! (id " + id + ")");
    }
}

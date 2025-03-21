package com.kev.springrest.exception.library;

public class SaveBookExistsException extends RuntimeException {
    public SaveBookExistsException(String title, long id) {
        super("Le livre \"" + title + "\" existe déjà ! (id " + id + ")");
    }
}

package com.kev.springrest.exception;

public class UpdateBookNotFoundException extends RuntimeException {
    public UpdateBookNotFoundException(String title, long id) {
        super("Le livre \"" + title + "\" (id " + id + ") n'a pas été trouvé.");
    }
}

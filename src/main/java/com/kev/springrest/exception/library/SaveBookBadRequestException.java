package com.kev.springrest.exception.library;

public class SaveBookBadRequestException extends RuntimeException {
    public SaveBookBadRequestException(String title) {
        super("Le livre : " + title + " n'a pas les champs requis.");
    }

}

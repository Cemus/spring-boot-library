package com.kev.springrest.exception;

public class PublisherBadRequestException extends RuntimeException {
    public PublisherBadRequestException(String message) {
            super("la maison d'édition : " + message + " n'a pas les champs requis.");
    }
}

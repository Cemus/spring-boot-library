package com.kev.springrest.exception;

public class DeleteBookException extends RuntimeException {
    public DeleteBookException(long id) {
      super("Le livre (id " + id + ") n'a pas été supprimé car il n'existe pas !"  );
    }
}

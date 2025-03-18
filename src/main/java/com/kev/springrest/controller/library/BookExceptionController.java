package com.kev.springrest.controller.library;

import com.kev.springrest.exception.library.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BookExceptionController {

    @ExceptionHandler(BooksNotFoundException.class)
    public ResponseEntity<Map<String, String>> bookNotFound(BooksNotFoundException booksNotFoundException) {
        Map <String, String> ErreurResponse = new HashMap<>();
        ErreurResponse.put("Erreur", booksNotFoundException.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErreurResponse);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String, String>> bookNotFound(BookNotFoundException bookNotFoundException) {
        Map <String, String> ErreurResponse = new HashMap<>();
        ErreurResponse.put("Erreur", bookNotFoundException.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErreurResponse);
    }

    @ExceptionHandler(SaveBookExistsException.class)
    public ResponseEntity<Map<String, String>> saveBookExists(SaveBookExistsException saveBookExists) {
        Map <String, String> ErreurResponse = new HashMap<>();
        ErreurResponse.put("Erreur", saveBookExists.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErreurResponse);
    }

    @ExceptionHandler(UpdateBookNotFoundException.class)
    public ResponseEntity<Map<String, String>> updateBookNotFound(UpdateBookNotFoundException updateBookNotFound) {
        Map <String, String> ErreurResponse = new HashMap<>();
        ErreurResponse.put("Erreur", updateBookNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ErreurResponse);
    }

    @ExceptionHandler(DeleteBookException.class)
    public ResponseEntity<Map<String, String>> updateBookNotFound(DeleteBookException deleteBookException) {
        Map <String, String> ErreurResponse = new HashMap<>();
        ErreurResponse.put("Erreur", deleteBookException.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ErreurResponse);
    }

    @ExceptionHandler(SaveBookBadRequestException.class)
    public ResponseEntity<Map<String, String>> saveBookBadRequest(SaveBookBadRequestException saveBookBadRequestException) {
        Map <String, String> ErreurResponse = new HashMap<>();
        ErreurResponse.put("Erreur", saveBookBadRequestException.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErreurResponse);
    }

}

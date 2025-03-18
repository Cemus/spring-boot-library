package com.kev.springrest.controller.library;

import com.kev.springrest.exception.library.PublisherBadRequestException;
import com.kev.springrest.exception.library.PublisherExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class PublisherExceptionController {

    @ExceptionHandler(PublisherExistsException.class)
    public ResponseEntity<Map<String, String>> savePublisherExists(PublisherExistsException publisherExistsException) {
        Map <String, String> ErreurResponse = new HashMap<>();
        ErreurResponse.put("Erreur", publisherExistsException.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErreurResponse);
    }

    @ExceptionHandler(PublisherBadRequestException.class)
    public ResponseEntity<Map<String, String>> savePublisherBadRequest(PublisherBadRequestException publisherBadRequestException) {
        Map <String, String> ErreurResponse = new HashMap<>();
        ErreurResponse.put("Erreur", publisherBadRequestException.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErreurResponse);
    }
}

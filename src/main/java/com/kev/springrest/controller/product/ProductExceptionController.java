package com.kev.springrest.controller.product;

import com.kev.springrest.exception.product.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> bookNotFound(ProductNotFoundException productNotFoundException) {
        Map <String, String> ErreurResponse = new HashMap<>();
        ErreurResponse.put("Erreur", productNotFoundException.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErreurResponse);
    }


}

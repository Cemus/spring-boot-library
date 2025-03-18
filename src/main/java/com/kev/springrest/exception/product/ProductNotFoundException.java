package com.kev.springrest.exception.product;


public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Le produit possédant l' " + id + " n'a pas été trouvé");
    }

    public ProductNotFoundException() {
        super("Aucun produit trouvé");
    }
}

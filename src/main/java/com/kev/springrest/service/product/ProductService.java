package com.kev.springrest.service.product;

import com.kev.springrest.exception.product.ProductNotFoundException;
import com.kev.springrest.model.Product;
import com.kev.springrest.repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findById(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product;
        }
        throw new ProductNotFoundException(id);
    }

    public Iterable<Product> findAll() {
        if (productRepository.count() == 0) {
            throw new ProductNotFoundException();
        }
        return productRepository.findAll();
    }
}

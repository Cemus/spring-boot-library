package com.kev.springrest.controller.product;

import com.kev.springrest.service.product.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String findAllProducts(Model model) {
        model.addAttribute("products",productService.findAll());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String findProductById(Model model, @Valid @PathVariable long id) {
        model.addAttribute("product",productService.findById(id));
        return "product";
    }

}

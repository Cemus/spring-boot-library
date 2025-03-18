package com.kev.springrest.controller.product;

import com.kev.springrest.model.Category;
import com.kev.springrest.model.Product;
import com.kev.springrest.service.product.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String findAllProducts(Model model) {
        Iterable<Product> products = productService.findAll();
        System.out.println(products);
        if (products.iterator().hasNext()) {
            model.addAttribute("products", products);
        }
        return "products";
    }

    @GetMapping("/product/{id}")
    public String findProductById(Model model, @Valid @PathVariable long id) {
        Optional<Product> product = productService.findById(id);
        System.out.println(product);
        product.ifPresent(value -> model.addAttribute("product", value));

        return "product";
    }

    @GetMapping("/product/add")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

    return "add-product";
    }

    @PostMapping("/product")
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }

}

package com.kev.springrest.controller.product;

import com.kev.springrest.model.Category;
import com.kev.springrest.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category/{id}")
    public String category(@PathVariable long id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        category.ifPresent(value -> model.addAttribute("category", value));
        return "category";
    }

    @RequestMapping("/categories")
    public String categories(Model model) {
        Iterable<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }
}

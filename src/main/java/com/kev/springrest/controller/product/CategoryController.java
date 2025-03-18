package com.kev.springrest.controller.product;

import com.kev.springrest.model.Category;
import com.kev.springrest.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{id}")
    public String getSingleCategory(@PathVariable long id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        category.ifPresent(value -> model.addAttribute("category", value));
        return "category";
    }

    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        Iterable<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @PostMapping("/category/add")
    public String addCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "add-category";
    }

    @PostMapping("/category")
    public String saveCategory(Category category){
        System.out.println(category);
        return "redirect:/categories";
    }
}

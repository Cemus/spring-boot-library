package com.kev.springrest.service.product;

import com.kev.springrest.model.Category;
import com.kev.springrest.repository.CategoryRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> getCategoryById(long id) {
        return categoryRepository.findById(id);
    }

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void saveCategory(Category category) {
         categoryRepository.save(category);
    }
}

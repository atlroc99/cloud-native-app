package com.jeffry.springcloud.controller;

import com.jeffry.springcloud.entity.Category;
import com.jeffry.springcloud.repository.CategoryRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.List;

@RestController
@RequestMapping("/categoryApi")
public class CategoryController {

    private final CategoryRepostiory repository;

    public CategoryController(CategoryRepostiory repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Category> getCategories() {
        return repository.findAll();
    }

    @GetMapping("/categories")
    public Category getCategoryByID(@RequestParam("categoryID") int categoryID) {
        boolean exists = repository.existsById(categoryID);
        if (exists) {
            return repository.findById(categoryID).get();
        }
        return new Category();
    }

    @PutMapping("/categories")
    public void updateCategory(Category category) {
        repository.save(category);
    }

    @PostMapping("/categories")
    public void addCategory(@RequestBody Category category) {
        repository.save(category);
    }

    @DeleteMapping("/categories/{categoryID}")
    public void deleteCategoryByID(@PathVariable("categoryID") int categoryID) {
        repository.deleteById(categoryID);
    }
}

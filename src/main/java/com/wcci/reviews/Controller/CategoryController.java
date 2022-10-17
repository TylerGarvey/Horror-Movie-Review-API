package com.wcci.reviews.Controller;

import com.wcci.reviews.Model.Category;
import com.wcci.reviews.Model.Hashtag;
import com.wcci.reviews.Repo.CategoryRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    private CategoryRepository categoryRepo;

    public CategoryController(CategoryRepository categoryRepo) {

        this.categoryRepo = categoryRepo;
    }

    @GetMapping("/categories")
    public Iterable<Category> getAllCategories() {

        return categoryRepo.findAll();
    }

    @GetMapping("/categories/{id}")
    public Category getSingleCategory(@PathVariable long id) {
        return categoryRepo.findById(id).get();
    }

    @PostMapping("/categories")
    public Iterable<Category> addNewCategory(@RequestBody Category newCategory) {
        categoryRepo.save(newCategory);
        return categoryRepo.findAll();
    }
}
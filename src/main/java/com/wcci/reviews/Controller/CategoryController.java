package com.wcci.reviews.Controller;

import com.wcci.reviews.Model.Category;
import com.wcci.reviews.Model.Hashtag;
import com.wcci.reviews.Model.Review;
import com.wcci.reviews.Repo.CategoryRepository;
import com.wcci.reviews.Repo.ReviewRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    private CategoryRepository categoryRepo;
    private ReviewRepository reviewRepo;

    public CategoryController(CategoryRepository categoryRepo, ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
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

    @GetMapping("/category/{id}/getReviews")
    public Iterable<Review> getReviewsByCategory(@PathVariable long id) {
        return categoryRepo.findById(id).get().getReviews();
    }

    @PostMapping("/categories")
    public Iterable<Category> addNewCategory(@RequestBody Category newCategory) {
        categoryRepo.save(newCategory);
        return categoryRepo.findAll();
    }
}
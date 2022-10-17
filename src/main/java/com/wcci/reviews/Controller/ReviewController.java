package com.wcci.reviews.Controller;

import com.wcci.reviews.Model.Review;
import com.wcci.reviews.Repo.ReviewRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    private ReviewRepository reviewRepo;

    public ReviewController(ReviewRepository reviewRepo) {

        this.reviewRepo = reviewRepo;
    }

    @GetMapping("/reviews")
    public Iterable<Review> getAllReviews(){

        return reviewRepo.findAll();
    }

    @GetMapping("/review/{id}")
    public Review getSingleReview(@PathVariable long id){
        return reviewRepo.findById(id).get();
    }

//    @GetMapping("/review/{id}/hashtag")

    @PostMapping("/reviews")
    public Iterable<Review> addNewReview(@RequestBody Review newReview) {
        reviewRepo.save(newReview);
        return reviewRepo.findAll();
    }
}

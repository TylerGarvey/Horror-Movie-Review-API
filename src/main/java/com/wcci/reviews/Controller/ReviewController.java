package com.wcci.reviews.Controller;

import com.wcci.reviews.Model.Hashtag;
import com.wcci.reviews.Model.Review;
import com.wcci.reviews.Repo.HashtagRepository;
import com.wcci.reviews.Repo.ReviewRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    private final HashtagRepository hashtagRepo;
    private ReviewRepository reviewRepo;
    private HashtagRepository hashtagRepository;

    public ReviewController(ReviewRepository reviewRepo, HashtagRepository hashtagRepo) {
        this.reviewRepo = reviewRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @GetMapping("/reviews")
    public Iterable<Review> getAllReviews(){
        return reviewRepo.findAll();
    }

    @GetMapping("/review/{id}")
    public Review getSingleReview(@PathVariable long id){
        return reviewRepo.findById(id).get();
    }

    @GetMapping("/review/{id}/getHashtags")
    public Iterable<Hashtag> getHashtags(@PathVariable long id){
        return reviewRepo.findById(id).get().getHashtag();
    }

    @PostMapping("/reviews")
    public Iterable<Review> addNewReview(@RequestBody Review newReview) {
        reviewRepo.save(newReview);
        return reviewRepo.findAll();
    }
}

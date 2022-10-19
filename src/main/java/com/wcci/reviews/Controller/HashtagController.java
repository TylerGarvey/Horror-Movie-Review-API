package com.wcci.reviews.Controller;

import com.wcci.reviews.Model.Hashtag;
import com.wcci.reviews.Model.Review;
import com.wcci.reviews.Repo.HashtagRepository;
import com.wcci.reviews.Repo.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;


@RestController
public class HashtagController {
    private HashtagRepository hashtagsRepo;
    private ReviewRepository reviewRepo;
    public HashtagController(HashtagRepository categoryRepo, ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
        this.hashtagsRepo = categoryRepo;
    }

    @GetMapping("/hashtags")
    public Iterable<Hashtag> getAllHashtags() {
        return hashtagsRepo.findAll();
    }

    @GetMapping("/hashtag/{id}")
    public Hashtag getSingleHashtag(@PathVariable long id) {
        return hashtagsRepo.findById(id).get();
    }

    @GetMapping("hashtag/{id}/reviews")
    public Iterable<Review> getReviewsByHashtag(@PathVariable long id) {
        return hashtagsRepo.findById(id).get().getReviews();
    }

    @PostMapping("/hashtags")
    public Iterable<Hashtag> addNewHashtag(@RequestBody Hashtag newHashtag) {
        hashtagsRepo.save(newHashtag);
        return hashtagsRepo.findAll();
    }

    @PutMapping("/hashtags/{id}/addToReview/{reviewId}")
    public Iterable<Hashtag> addHashtagToReview(@PathVariable long id, @PathVariable long reviewId) throws Exception {
        Optional<Hashtag> optionalHashtag = hashtagsRepo.findById(id);
        Optional<Review> optionalReview = reviewRepo.findById(reviewId);
        if (optionalHashtag.isPresent() && optionalReview.isPresent()) {
            Review review = optionalReview.get();
            Hashtag hashtag = optionalHashtag.get();
            review.setHashtag(hashtag);
            hashtag.addReview(review);
            reviewRepo.save(review);
            hashtagsRepo.save(hashtag);
        }
        else {
            throw new Exception("Hashtag or Review cannot be found");
        }
        return hashtagsRepo.findAll();
    }
}

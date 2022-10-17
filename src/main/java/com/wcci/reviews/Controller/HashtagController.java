package com.wcci.reviews.Controller;

import com.wcci.reviews.Model.Hashtag;
import com.wcci.reviews.Model.Review;
import com.wcci.reviews.Repo.HashtagRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class HashtagController {
    private HashtagRepository hashtagsRepo;

    public HashtagController(HashtagRepository categoryRepo) {

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

//    @GetMapping("hashtag/reviews")
//    public Iterable<Review> getReviewsByHashtag(@PathVariable long id) {
//        hashtagsRepo.findAllById(id)
//        return reviewRepo().findAll()
//    }

    @PostMapping("/hashtags")
    public Iterable<Hashtag> addNewHashtag(@RequestBody Hashtag newHashtag) {
        hashtagsRepo.save(newHashtag);
        return hashtagsRepo.findAll();
    }
}

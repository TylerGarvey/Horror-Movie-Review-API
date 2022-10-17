package com.wcci.reviews.Repo;

import com.wcci.reviews.Model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}

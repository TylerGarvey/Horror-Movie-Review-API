package com.wcci.reviews;

import com.wcci.reviews.Model.Category;
import com.wcci.reviews.Model.Review;
import com.wcci.reviews.Model.Hashtag;
import com.wcci.reviews.Repo.CategoryRepository;
import com.wcci.reviews.Repo.HashtagRepository;
import com.wcci.reviews.Repo.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner{
    private HashtagRepository hashtagRepo;
    private CategoryRepository categoryRepo;
    private ReviewRepository reviewRepo;

    public Populator(ReviewRepository reviewRepo, CategoryRepository categoryRepo, HashtagRepository hashtagRepo) {
        this.categoryRepo= categoryRepo;
        this.reviewRepo = reviewRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Category category1= new Category("zombie");
        categoryRepo.save(category1);

        Category category2= new Category("comedy");
        categoryRepo.save(category2);

        Category category3= new Category("alien");
        categoryRepo.save(category3);

        Category category4 = new Category("ghost");
        categoryRepo.save(category4);



        Review review1 = new Review("28 Days Later", "Red Garvey", "20 years later & 28 Days later will still have you running in terror!","4 severed thumbs up!", category1);
        reviewRepo.save(review1);

        Review review2 = new Review("Tucker & Dale vs. Evil","Tyler Gravy","Laugh riot & the best wood chipper scene since Fargo!", "2 severed thumbs up!", category2);
        reviewRepo.save(review2);

        Review review3 = new Review("The Thing", "Gyler Tarvey","The thing about 'The Thing' is that it will make you feel isolated..& you'll love it.", "3 severed thumbs up!", category3);
        reviewRepo.save(review3);

        Review review4 = new Review("Sleepy Hollow","Major Garvey","Interesting twist on a classic tale with some good effects","1 severed thumbs up!", category4);
        reviewRepo.save(review4);



        Hashtag hashtag1 = new Hashtag("bloody mess", review2, review4);
        hashtagRepo.save(hashtag1);

        Hashtag hashtag2 = new Hashtag("laugh riot", review2);
        hashtagRepo.save(hashtag2);

        Hashtag hashtag3 = new Hashtag("star studded cast", review3, review2, review4);
        hashtagRepo.save(hashtag3);

        Hashtag hashtag4 = new Hashtag("mystery wrapped in horror", review4, review3);
        hashtagRepo.save(hashtag4);

    }


}

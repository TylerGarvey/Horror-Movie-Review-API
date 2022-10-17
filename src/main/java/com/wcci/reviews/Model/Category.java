package com.wcci.reviews.Model;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;
    private String subgenre;

    @OneToMany(mappedBy="category")
    private Collection<Review> reviews;


    public Category(String subgenre) {
        this.subgenre = subgenre;
    }

    public Category() {
    }

    public long getId() {
        return id;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }
}

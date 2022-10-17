package com.wcci.reviews.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Hashtag {


    @Id
    @GeneratedValue
    private long id;
    private String contentTag;

    @ManyToMany
    @JsonIgnore
    private Collection<Review> reviews;
    public Hashtag(String contentTag, Review... reviews) {
        this.contentTag = contentTag;
        this.reviews = Arrays.asList(reviews);//?check this
    }

    public Hashtag() {
    }

    public String getContentTag() {
        return contentTag;
    }

    public long getId() {
        return id;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }
}

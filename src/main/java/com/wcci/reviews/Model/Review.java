package com.wcci.reviews.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String author;
    private String description;
    private String rating;

    @ManyToOne
    @JsonIgnore
    private Category category;

    @ManyToMany(mappedBy = "reviews")
    private Collection<Hashtag> hashtags;

    public Review(String title, String author, String description, String rating, Category category) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.rating = rating;
        this.category = category;
    }

    public Review() {
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {

        return title;
    }

    public String getAuthor() {

        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Collection<Hashtag> getHashtag() { return hashtags; }
}
package com.in28minutes.jpa.database.demo.oneToone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String rating;
    @Column(name="description", nullable = false)
    private String description;

    protected Review(){}

    public long getId() {
        return id;
    }

    public Review(String description, String ratings) {
        this.description = description;
        this.rating = ratings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("Review[%s %s]",rating,description );
    }
}

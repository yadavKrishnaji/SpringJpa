package com.in28minutes.jpa.database.demo.oneToMany.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class ReviewOneToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String rating;
    @ManyToOne
    private CourseOneToMany course;
    @Column(name="description", nullable = false)
    private String description;

    protected ReviewOneToMany(){}

    public long getId() {
        return id;
    }

    public ReviewOneToMany(String description, String ratings) {
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

    public CourseOneToMany getCourse() {
        return course;
    }

    public void setCourse(CourseOneToMany course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("Review[%s %s]",rating,description );
    }
}

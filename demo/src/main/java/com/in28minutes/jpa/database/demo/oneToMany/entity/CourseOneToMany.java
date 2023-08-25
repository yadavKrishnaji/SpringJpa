package com.in28minutes.jpa.database.demo.oneToMany.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses_manyToOne",query = "SELECT  C FROM Course C"),
        @NamedQuery(name = "query_get_all_100Steps_courses_manyToOne",query = "SELECT  C FROM Course C where name like'%100 steps'")
})
public class CourseOneToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "course")
    private List<ReviewOneToMany> reviews = new ArrayList<>();
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;
    protected CourseOneToMany(){}

    public long getId() {
        return id;
    }

    public CourseOneToMany(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReviewOneToMany> getReviews() {
        return reviews;
    }

    public void addReviews(ReviewOneToMany reviews) {
        this.reviews.add(reviews);
    }
    public void removeReviews(ReviewOneToMany reviews) {
        this.reviews.remove(reviews);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}

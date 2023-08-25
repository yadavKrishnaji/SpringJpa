package com.in28minutes.jpa.database.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "course")
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses",query = "SELECT  C FROM Course C"),
        @NamedQuery(name = "query_get_all_100Steps_courses",query = "SELECT  C FROM Course C where name like'%100 steps'")
})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name", nullable = false)
    private String name;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;
    protected Course(){}

    public long getId() {
        return id;
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}

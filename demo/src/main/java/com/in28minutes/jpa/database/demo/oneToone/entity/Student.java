package com.in28minutes.jpa.database.demo.oneToone.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name", nullable = false)
    private String name;

    //@OneToOne(cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.LAZY)
    private  Passport passport;
    protected Student(){}

    public long getId() {
        return id;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return String.format("Stundet[%s]",name );
    }
}

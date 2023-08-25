package com.in28minutes.jpa.database.demo.oneToMany.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentOneToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name", nullable = false)
    private String name;

    //@OneToOne(cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.LAZY)
    private PassportOneToMany passport;
    protected StudentOneToMany(){}

    public long getId() {
        return id;
    }

    public StudentOneToMany(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PassportOneToMany getPassport() {
        return passport;
    }

    public void setPassport(PassportOneToMany passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return String.format("Stundet[%s]",name );
    }
}

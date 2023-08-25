package com.in28minutes.jpa.database.demo.oneToone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="number", nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private  Student student;

    protected Passport(){}

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public Passport(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Pasport[%s]",number );
    }
}

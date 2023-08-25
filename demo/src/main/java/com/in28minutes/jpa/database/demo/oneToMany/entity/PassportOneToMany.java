package com.in28minutes.jpa.database.demo.oneToMany.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passport")
public class PassportOneToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="number", nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private StudentOneToMany studentOneToMany;

    protected PassportOneToMany(){}

    public StudentOneToMany getStudent() {
        return studentOneToMany;
    }

    public void setStudent(StudentOneToMany studentOneToMany) {
        this.studentOneToMany = studentOneToMany;
    }

    public long getId() {
        return id;
    }

    public PassportOneToMany(String number) {
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

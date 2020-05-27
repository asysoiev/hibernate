package com.sandbox.hibernate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Andrii Sysoiev
 */
@Entity
public class Passport {

    @Id
    @SequenceGenerator(name = "passport_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(generator = "passport_seq")
    private Long id;
    private String number;
    @JsonIgnore
    @OneToOne(mappedBy = "passport")
    private Student student;

    public Long getId() {
        return id;
    }

    public Passport setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Passport setNumber(String number) {
        this.number = number;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public Passport setStudent(Student student) {
        this.student = student;
        return this;
    }
}

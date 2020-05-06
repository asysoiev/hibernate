package com.sandbox.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Andrii Sysoiev
 */
@Entity
public class Student {

    @Id
    @SequenceGenerator(name = "student_seq", allocationSize = 1, initialValue = 20000)
    @GeneratedValue(generator = "student_seq")
    private Long id;
    private String name;
    private String surname;
    @OneToOne
    private Passport passport;

    public Long getId() {
        return id;
    }

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Student setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Passport getPassport() {
        return passport;
    }

    public Student setPassport(Passport passport) {
        this.passport = passport;
        return this;
    }
}

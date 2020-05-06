package com.sandbox.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
}

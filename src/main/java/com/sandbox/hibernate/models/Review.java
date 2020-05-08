package com.sandbox.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Andrii Sysoiev
 */
@Entity
public class Review {

    @Id
    @SequenceGenerator(name = "review_seq", allocationSize = 1, initialValue = 30000)
    @GeneratedValue(generator = "review_seq")
    private Long id;
    private Integer rate;
    private String comment;
    @ManyToOne
    private Course course;

    public Long getId() {
        return id;
    }

    public Review setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getRate() {
        return rate;
    }

    public Review setRate(Integer rate) {
        this.rate = rate;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Review setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public Review setCourse(Course course) {
        this.course = course;
        return this;
    }
}

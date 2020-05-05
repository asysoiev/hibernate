package com.sandbox.hibernate.models;

import java.util.Objects;

/**
 * @author Andrii Sysoiev
 */
public class Course {

    private Long id;
    private String title;

    protected Course() {
        //is used by hibernate
    }

    public Course(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public Course setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Course setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(title, course.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}

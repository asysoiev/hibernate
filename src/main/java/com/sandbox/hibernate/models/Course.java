package com.sandbox.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

/**
 * @author Andrii Sysoiev
 */
@Entity
@NamedQueries(
        {
                @NamedQuery(name = "Course.findAll", query = "select c from Course c"),
                @NamedQuery(name = "Course.findByTitle", query = "select c from Course c where c.title like :title"),
        }
)
//@Cacheable
public class Course {

    @Id
    @SequenceGenerator(name = "course_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(generator = "course_seq")
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

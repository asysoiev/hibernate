package com.sandbox.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

/**
 * @author Andrii Sysoiev
 */
@Entity
@NamedQueries(
        {
                @NamedQuery(name = "Course.getAll", query = "select c from Course c order by c.title"),
                @NamedQuery(name = "Course.findByTitle", query = "select c from Course c where c.title like :title"),
                @NamedQuery(name = "Course.getWithoutStudents", query = "select c from Course c where c.students is empty"),
        }
)
//@Cacheable
public class Course {

    @Id
    @SequenceGenerator(name = "course_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(generator = "course_seq")
    private Long id;
    private String title;
    @OneToMany(mappedBy = "course", fetch = EAGER, cascade = ALL)
    private final List<Review> reviews;
    @ManyToMany
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private final List<Student> students;

    protected Course() {
        //is used by hibernate
        reviews = new ArrayList<>();
        students = new ArrayList<>();
    }

    public Course(String title) {
        this();
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public void addReviews(List<Review> reviews) {
        this.reviews.addAll(reviews);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public void addStudent(Student student) {
        students.add(student);
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

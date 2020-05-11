package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Course;
import com.sandbox.hibernate.models.Review;
import com.sandbox.hibernate.models.Student;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Andrii Sysoiev
 */
public interface CourseService {


    List<Course> getAll();

    Course findById(Long id);

    List<Course> findByTitle(String title);

    List<Course> getCoursesWithoutStudents();


    Course createCourse(Course course);

    Course updateCourse(Course course);

    void deleteById(Long id);

    void addReviews(Long courseId, List<Review> reviews);

    default void addStudents(Long courseId, Student... students) {
        addStudents(courseId, asList(students));
    }

    void addStudents(Long courseId, List<Student> student);

    List<Course> getCoursesWithAtLeastStudents(int studentsCount);
}

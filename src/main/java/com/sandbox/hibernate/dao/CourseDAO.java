package com.sandbox.hibernate.dao;

import com.sandbox.hibernate.models.Course;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrii Sysoiev
 */
public interface CourseDAO {

    List<Course> getAll();

    Optional<Course> findById(Long id);

    List<Course> findByTitle(String title);

    List<Course> getCoursesWithoutStudents();


    Course insert(Course course);

    Course update(Course course);

    void delete(Course course);

}

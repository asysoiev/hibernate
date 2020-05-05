package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Course;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
public interface CourseService {


    List<Course> findAll();

    Course findById(Long id);

    List<Course> findByTitle(String title);


    Course createCourse(Course course);

    Course updateCourse(Course course);

    void deleteById(Long id);

}

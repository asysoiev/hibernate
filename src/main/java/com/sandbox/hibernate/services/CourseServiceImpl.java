package com.sandbox.hibernate.services;

import com.sandbox.hibernate.dao.CourseDAO;
import com.sandbox.hibernate.exceptions.CourseNotFoundException;
import com.sandbox.hibernate.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseDAO.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    @Override
    public List<Course> findByTitle(String title) {
        return courseDAO.findByTitle(title);
    }

    @Override
    public Course createCourse(Course course) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override
    public Course updateCourse(Course course) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not implemented.");
    }
}

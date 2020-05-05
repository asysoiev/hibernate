package com.sandbox.hibernate.services;

import com.sandbox.hibernate.dao.CourseDAO;
import com.sandbox.hibernate.exceptions.CourseNotFoundException;
import com.sandbox.hibernate.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public Course createCourse(Course course) {
        return courseDAO.insert(course);
    }

    @Transactional
    @Override
    public Course updateCourse(Course course) {
        return courseDAO.update(course);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Course course = findById(id);
        courseDAO.delete(course);
    }
}

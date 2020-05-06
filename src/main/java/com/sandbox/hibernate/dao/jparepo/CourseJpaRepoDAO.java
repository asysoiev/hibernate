package com.sandbox.hibernate.dao.jparepo;

import com.sandbox.hibernate.dao.CourseDAO;
import com.sandbox.hibernate.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaRepo")
@Repository
public class CourseJpaRepoDAO implements CourseDAO {
    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Override
    public List<Course> findAll() {
        return courseJpaRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseJpaRepository.findById(id);
    }

    @Override
    public List<Course> findByTitle(String title) {
        return courseJpaRepository.findByTitleContains(title);
    }

    @Override
    public Course insert(Course course) {
        return courseJpaRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseJpaRepository.save(course);
    }

    @Override
    public void delete(Course course) {
        courseJpaRepository.delete(course);
    }
}

package com.sandbox.hibernate.dao.em;

import com.sandbox.hibernate.dao.CourseDAO;
import com.sandbox.hibernate.models.Course;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * JPA Entity Manager implementation
 *
 * @author Andrii Sysoiev
 */
@Profile("JpaEM")
@Repository
public class CourseJpaEmDAO implements CourseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Course> findAll() {
        TypedQuery<Course> query = entityManager.createNamedQuery("Course.findAll", Course.class);
        return query.getResultList();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Course.class, id));
    }

    @Override
    public List<Course> findByTitle(String title) {
        String likeWrappedTitle = "%" + title + "%";
        TypedQuery<Course> query = entityManager.createNamedQuery("Course.findByTitle", Course.class);
        query.setParameter("title", likeWrappedTitle);
        return query.getResultList();
    }

    @Override
    public Course insert(Course course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    public Course update(Course course) {
        entityManager.merge(course);
        return course;
    }

    @Override
    public void delete(Course course) {
        entityManager.remove(course);
    }
}

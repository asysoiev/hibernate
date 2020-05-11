package com.sandbox.hibernate.dao.jparepo;

import com.sandbox.hibernate.models.Course;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaRepo")
@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitleContains(String title);

    @Query("select c from Course c where c.students is empty")
    List<Course> getCoursesWithoutStudents();
}

package com.sandbox.hibernate.dao.jparepo;

import com.sandbox.hibernate.models.Course;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaRepo")
@Repository
@RepositoryRestResource(path = "courses")
public interface CourseJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitleContains(String title);

    @Query("select c from Course c where c.students is empty")
    List<Course> getCoursesWithoutStudents();

    @Query("select c from Course c where size(c.students) >= :studentsCount")
    List<Course> getCoursesWithAtLeastStudents(@Param("studentsCount") int studentsCount);
}

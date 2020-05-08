package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static com.sandbox.hibernate.services.CourseServiceTest.dockerCourseData;
import static com.sandbox.hibernate.services.CourseServiceTest.hibernateCourseData;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Andrii Sysoiev
 */
//DirtyContext is used instead of transactional
//for checking changes from JPA by JdbcTemplate
//@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public abstract class CourseReviewTest {

    @Autowired
    private CourseService courseService;

    @Test
    void testGetCourseWithReviews() {
        Course course = courseService.findById(hibernateCourseData.getId());
        assertNotNull(course.getReviews());
        assertEquals(2, course.getReviews().size());
    }

    @Test
    void testGetCourseWithoutReviews() {
        Course course = courseService.findById(dockerCourseData.getId());
        assertNotNull(course.getReviews());
        assertTrue(course.getReviews().isEmpty());
    }
}

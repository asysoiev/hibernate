package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Course;
import com.sandbox.hibernate.models.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.jdbc.JdbcTestUtils.countRowsInTableWhere;

/**
 * @author Andrii Sysoiev
 */
public abstract class CourseReviewTest extends BaseServiceTest {

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

    @DirtiesContext
    @Test
    void testAddReviews() {
        int reviewsCount = getReviewsCount(hibernateCourseData.getId());
        assertEquals(2, reviewsCount);

        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review().setRate(5).setComment("New review 1"));
        reviews.add(new Review().setRate(2).setComment("New review 2"));
        courseService.addReviews(hibernateCourseData.getId(), reviews);

        reviewsCount = getReviewsCount(hibernateCourseData.getId());
        assertEquals(4, reviewsCount);
    }

    private int getReviewsCount(Long courseId) {
        return countRowsInTableWhere(jdbcTemplate, "review", format("course_id=%d", courseId));
    }
}

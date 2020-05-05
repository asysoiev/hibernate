package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.jdbc.JdbcTestUtils.countRowsInTableWhere;

/**
 * @author Andrii Sysoiev
 */
//DirtyContext is used instead of transactional
//for checking changes from JPA by JdbcTemplate
//@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public abstract class CourseServiceTest {

    private static final Course dockerCourseData = new Course("Master Docker with Java - DevOps for Spring Microservices")
            .setId(10000L);
    private static final Course hibernateCourseData = new Course("Master Hibernate and JPA with Spring Boot in 100 Steps")
            .setId(10001L);
    private static final Course microservicesCourseData = new Course("Master Microservices with Spring Boot and Spring Cloud")
            .setId(10002L);
    @Autowired
    private CourseService courseService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testFindAll() {
        List<Course> result = courseService.findAll();
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    void testFindById() {
        Course result = courseService.findById(hibernateCourseData.getId());
        assertNotNull(result);
        assertEquals(hibernateCourseData.getTitle(), result.getTitle());
    }

    @Test
    void testFindByTitle() {
        List<Course> result = courseService.findByTitle("Spring Boot");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(hibernateCourseData));
        assertTrue(result.contains(microservicesCourseData));
    }

    @DirtiesContext
    @Test
    void testCreateCourse() {
        String title = "Course to insert";
        int count = getCoursesCountByTitle(title);
        assertEquals(0, count);

        Course newCourse = new Course(title);
        Course createdCourse = courseService.createCourse(newCourse);
        assertNotNull(createdCourse);
        assertNotNull(createdCourse.getId());

        count = getCoursesCountByTitle(title);
        assertEquals(1, count);
    }

    private int getCoursesCountByTitle(String title) {
        String whereClause = String.format("title=\'%s\'", title);
        return getCoursesCount(whereClause);
    }

    private int getCoursesCount(String whereClause) {
        return countRowsInTableWhere(jdbcTemplate, "course", whereClause);
    }
}

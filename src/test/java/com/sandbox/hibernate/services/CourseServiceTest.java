package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Andrii Sysoiev
 */
public abstract class CourseServiceTest extends BaseServiceTest {

    @Autowired
    private CourseService courseService;

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

    @DirtiesContext
    @Test
    void testUpdateCourse() {
        String updatedTitle = microservicesCourseData.getTitle() + " - Updated";
        int count = getCoursesCountByTitle(updatedTitle);
        assertEquals(0, count);

        long id = getCourseIdByTitle(microservicesCourseData.getTitle());
        Course updatedCourse = new Course(updatedTitle)
                .setId(id);
        courseService.updateCourse(updatedCourse);

        count = getCoursesCountByTitle(updatedTitle);
        assertEquals(1, count);
    }

    @DirtiesContext
    @Test
    void testDeleteCourse() {
        String title = microservicesCourseData.getTitle();
        int count = getCoursesCountByTitle(title);
        assertEquals(1, count);

        long id = getCourseIdByTitle(title);
        courseService.deleteById(id);

        count = getCoursesCountByTitle(title);
        assertEquals(0, count);
    }
}

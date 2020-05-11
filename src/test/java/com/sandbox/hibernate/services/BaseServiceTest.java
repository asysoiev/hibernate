package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

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
public abstract class BaseServiceTest {

    protected static final Course dockerCourseData = new Course("Master Docker with Java - DevOps for Spring Microservices")
            .setId(10000L);
    protected static final Course hibernateCourseData = new Course("Master Hibernate and JPA with Spring Boot in 100 Steps")
            .setId(10001L);
    protected static final Course microservicesCourseData = new Course("Master Microservices with Spring Boot and Spring Cloud")
            .setId(10002L);
    protected static final Course performanceCourseData = new Course("Java Application Performance and Memory Management")
            .setId(10003L);
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    protected long getCourseIdByTitle(String title) {
        String query = "select id from course where title=?";
        return jdbcTemplate.queryForObject(query, new Object[]{title}, Long.class);
    }

    protected int getCoursesCountByTitle(String title) {
        String whereClause = String.format("title=\'%s\'", title);
        return getCoursesCount(whereClause);
    }

    protected int getCoursesCount(String whereClause) {
        return countRowsInTableWhere(jdbcTemplate, "course", whereClause);
    }
}

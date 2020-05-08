package com.sandbox.hibernate.dao.jdbc;

import com.sandbox.hibernate.dao.CourseDAO;
import com.sandbox.hibernate.models.Course;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author Andrii Sysoiev
 */
@Profile("JdbcTemplate")
@Repository
public class CourseJdbcTemplateDAO implements CourseDAO {

    private static final Logger logger = getLogger(CourseJdbcTemplateDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Course> findAll() {
        return jdbcTemplate.query("select * from course", new BeanPropertyRowMapper<>(Course.class));
    }

    @Override
    public Optional<Course> findById(Long id) {
        Course dbResult = null;
        try {
            dbResult = jdbcTemplate.queryForObject("select * from course where id=?", new Object[]{id},
                    new BeanPropertyRowMapper<>(Course.class)
            );
        } catch (EmptyResultDataAccessException e) {
            logger.warn("Citizen \"{}\" not found", id);
        }
        return Optional.ofNullable(dbResult);
    }

    @Override
    public List<Course> findByTitle(String title) {
        String likeWrappedTitle = "%" + title + "%";
        return jdbcTemplate.query("select * from course where title like ?",
                new Object[]{likeWrappedTitle},
                new BeanPropertyRowMapper<>(Course.class));
    }

    @Override
    public Course insert(Course course) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("course")
                .usingGeneratedKeyColumns("id");
        Map<String, Object> args = new HashMap<>();
        args.put("title", course.getTitle());
        Long id = (Long) simpleJdbcInsert.executeAndReturnKey(args);
        course.setId(id);
        return course;
    }

    @Override
    public Course update(Course course) {
        jdbcTemplate.update("update course " +
                        "set title = ? " +
                        "where id = ?",
                new Object[]{course.getTitle(),
                        course.getId()});
        return course;
    }

    @Override
    public void delete(Course course) {
        Long id = course.getId();
        int deletedRecs = jdbcTemplate.update("delete from review where course_id=?", new Object[]{id});
        logger.debug("Deleted review records {} by course_id {}", deletedRecs, id);
        deletedRecs = jdbcTemplate.update("delete from course where id=?", new Object[]{id});
        logger.debug("Deleted course records {} by id {}", deletedRecs, id);
    }
}

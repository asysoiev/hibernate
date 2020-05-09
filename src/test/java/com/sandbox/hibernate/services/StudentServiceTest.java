package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Course;
import com.sandbox.hibernate.models.Passport;
import com.sandbox.hibernate.models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Andrii Sysoiev
 */
public abstract class StudentServiceTest extends BaseServiceTest {

    @Autowired
    private StudentService studentService;

    @Transactional//to wrap studentService.findById, student.getCourses by one session
    @Test
    void testFindById() {
        long id = 20000L;

        Student student = studentService.findById(id);

        assertNotNull(student);
        assertNotNull(student.getPassport());
        List<Course> courses = student.getCourses();
        assertNotNull(courses);
        assertEquals(2, courses.size());
    }

    @DirtiesContext
    @Test
    void testCreateStudent() {
        String name = "Ivan";
        String surname = "Petrov";
        Student newStudent = new Student()
                .setName(name)
                .setSurname(surname);

        String passportNumber = "A8391209";
        Passport passport = new Passport()
                .setNumber(passportNumber);
        newStudent.setPassport(passport);

        Student createdStudent = studentService.createStudent(newStudent);

        assertNotNull(createdStudent);
        assertNotNull(createdStudent.getId());
        assertNotNull(createdStudent.getPassport());
        assertNotNull(createdStudent.getPassport().getId());
    }
}

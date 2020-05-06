package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Passport;
import com.sandbox.hibernate.models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Andrii Sysoiev
 */
//DirtyContext is used instead of transactional
//for checking changes from JPA by JdbcTemplate
//@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public abstract class StudentServiceTest {

    @Autowired
    private StudentService studentService;

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

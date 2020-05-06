package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Passport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

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
public abstract class PassportServiceTest {

    @Autowired
    private PassportService passportService;

    @Test
    void testFindById() {
        long id = 40000L;

        Passport passport = passportService.findById(id);

        assertNotNull(passport);
        assertNotNull(passport.getStudent());
    }
}

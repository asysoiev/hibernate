package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Passport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Andrii Sysoiev
 */
public abstract class PassportServiceTest extends BaseServiceTest {

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

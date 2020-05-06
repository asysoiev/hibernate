package com.sandbox.hibernate.dao.em;

import com.sandbox.hibernate.dao.PassportDAO;
import com.sandbox.hibernate.models.Passport;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaEM")
@Repository
public class PassportJpaEmDAO implements PassportDAO {
    @Override
    public Passport insert(Passport passport) {
        throw new UnsupportedOperationException("Not implemented.");
    }
}

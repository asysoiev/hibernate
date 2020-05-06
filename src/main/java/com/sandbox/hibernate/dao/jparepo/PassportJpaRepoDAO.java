package com.sandbox.hibernate.dao.jparepo;

import com.sandbox.hibernate.dao.PassportDAO;
import com.sandbox.hibernate.models.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaRepo")
@Repository
public class PassportJpaRepoDAO implements PassportDAO {

    @Autowired
    private PassportJpaRepository passportJpaRepository;

    @Override
    public Optional<Passport> findById(Long id) {
        return passportJpaRepository.findById(id);
    }

    @Override
    public Passport insert(Passport passport) {
        return passportJpaRepository.save(passport);
    }
}

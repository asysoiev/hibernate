package com.sandbox.hibernate.dao;

import com.sandbox.hibernate.models.Passport;

import java.util.Optional;

/**
 * @author Andrii Sysoiev
 */
public interface PassportDAO {

    Optional<Passport> findById(Long id);

    Passport insert(Passport passport);

}

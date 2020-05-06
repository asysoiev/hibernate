package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Passport;

/**
 * @author Andrii Sysoiev
 */
public interface PassportService {

    Passport findById(Long id);

    Passport createPassport(Passport passport);

}

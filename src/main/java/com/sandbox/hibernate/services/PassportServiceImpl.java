package com.sandbox.hibernate.services;

import com.sandbox.hibernate.dao.PassportDAO;
import com.sandbox.hibernate.exceptions.PassportNotFoundException;
import com.sandbox.hibernate.models.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Andrii Sysoiev
 */
@Service
public class PassportServiceImpl implements PassportService {

    @Autowired
    private PassportDAO passportDAO;

    @Override
    public Passport findById(Long id) {
        return passportDAO.findById(id).orElseThrow(() -> new PassportNotFoundException(id));
    }

    @Transactional
    @Override
    public Passport createPassport(Passport passport) {
        return passportDAO.insert(passport);
    }
}

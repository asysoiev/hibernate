package com.sandbox.hibernate.services;

import com.sandbox.hibernate.dao.PassportDAO;
import com.sandbox.hibernate.dao.StudentDAO;
import com.sandbox.hibernate.exceptions.StudentNotFoundException;
import com.sandbox.hibernate.models.Passport;
import com.sandbox.hibernate.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Andrii Sysoiev
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private PassportDAO passportDAO;

    @Override
    public Student findById(Long id) {
        return studentDAO.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Transactional
    @Override
    public Student createStudent(Student student) {
        Passport passport = student.getPassport();
        if (passport != null) {
            passportDAO.insert(passport);
        }
        return studentDAO.insert(student);
    }
}

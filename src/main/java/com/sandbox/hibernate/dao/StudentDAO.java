package com.sandbox.hibernate.dao;

import com.sandbox.hibernate.models.Student;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrii Sysoiev
 */
public interface StudentDAO {

    Optional<Student> findById(Long id);

    /**
     * @param pattern
     * @return studens which passport number contains the pattern
     */
    List<Student> findByPassportNumber(String pattern);

    Student insert(Student student);
}

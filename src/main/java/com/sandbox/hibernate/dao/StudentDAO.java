package com.sandbox.hibernate.dao;

import com.sandbox.hibernate.models.Student;

import java.util.Optional;

/**
 * @author Andrii Sysoiev
 */
public interface StudentDAO {

    Optional<Student> findById(Long id);

    Student insert(Student student);
}

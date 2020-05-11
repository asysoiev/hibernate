package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Student;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
public interface StudentService {

    Student findById(Long id);

    Student createStudent(Student student);

    List<Student> findByPassportNumber(String pattern);
}

package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.Student;

/**
 * @author Andrii Sysoiev
 */
public interface StudentService {

    Student findById(Long id);

    Student createStudent(Student student);
}

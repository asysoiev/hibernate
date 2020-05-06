package com.sandbox.hibernate.exceptions;

import static java.lang.String.format;

/**
 * @author Andrii Sysoiev
 */
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super(format("Student with id: \"%d\" not found", id));
    }
}

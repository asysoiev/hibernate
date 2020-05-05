package com.sandbox.hibernate.exceptions;

import static java.lang.String.format;

/**
 * @author Andrii Sysoiev
 */
public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long id) {
        super(format("Course with id: \"%d\" not found", id));
    }
}

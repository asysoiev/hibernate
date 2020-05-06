package com.sandbox.hibernate.exceptions;

import static java.lang.String.format;

/**
 * @author Andrii Sysoiev
 */
public class PassportNotFoundException extends RuntimeException {
    public PassportNotFoundException(Long id) {
        super(format("Passport with id: \"%d\" not found", id));
    }
}

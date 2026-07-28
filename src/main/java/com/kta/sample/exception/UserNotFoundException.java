package com.kta.sample.exception;

import java.io.Serial;

public class UserNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5050L;

    public UserNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }
}

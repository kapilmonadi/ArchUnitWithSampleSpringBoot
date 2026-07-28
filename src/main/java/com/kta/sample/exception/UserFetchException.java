package com.kta.sample.exception;

import java.io.Serial;

public class UserFetchException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5050L;

    public UserFetchException(String message) {
        super(message);
    }
}

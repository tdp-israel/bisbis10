package com.att.tdp.bisbis10.exception.pagination;

import com.att.tdp.bisbis10.exception.InvalidValueException;

public class InvalidPageValueException extends InvalidValueException {
    static String message = "Page number must be a non-negative value!";

    public InvalidPageValueException() {
        super(InvalidPageValueException.message);
    }

    public InvalidPageValueException(String message) {
        super(message);
    }

    public InvalidPageValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPageValueException(Throwable cause) {
        super(InvalidPageValueException.message, cause);
    }
}

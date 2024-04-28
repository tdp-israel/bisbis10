package com.att.tdp.bisbis10.exception.pagination;

import com.att.tdp.bisbis10.exception.InvalidValueException;

public class InvalidPageSizeValueException extends InvalidValueException {
    static String message = "Page Size number must be a non-negative value!";


    public InvalidPageSizeValueException() {
        super(InvalidPageSizeValueException.message);
    }

    public InvalidPageSizeValueException(String message) {
        super(message);
    }

    public InvalidPageSizeValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPageSizeValueException(Throwable cause) {
        super(InvalidPageSizeValueException.message, cause);
    }
}

package com.what2drive.service_common.utils;

public class ArgumentsAreNullException extends RuntimeException {
    public ArgumentsAreNullException() {

    }

    public ArgumentsAreNullException(String message) {
        super(message);
    }

    public ArgumentsAreNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgumentsAreNullException(Throwable cause) {
        super(cause);
    }

    public ArgumentsAreNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
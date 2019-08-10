package com.what2drive.service_common.converters;

public class ConversionForbiddenException extends ConversionException {
    public ConversionForbiddenException() {

    }

    public ConversionForbiddenException(String message) {
        super(message);
    }

    public ConversionForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConversionForbiddenException(Throwable cause) {
        super(cause);
    }

    public ConversionForbiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
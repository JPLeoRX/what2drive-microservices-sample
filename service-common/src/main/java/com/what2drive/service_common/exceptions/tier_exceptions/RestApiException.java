package com.what2drive.service_common.exceptions.tier_exceptions;

import com.what2drive.service_common.exceptions.WebException;

/**
 * An exception to be used in all REST APIs
 *
 * All your exceptions that are used in REST APIs must extend this exception
 *
 * @author Leo Ertuna
 * @since 17.05.2018 21:09
 */
public class RestApiException extends WebException {
    public RestApiException() {

    }

    public RestApiException(String message) {
        super(message);
    }

    public RestApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestApiException(Throwable cause) {
        super(cause);
    }

    public RestApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
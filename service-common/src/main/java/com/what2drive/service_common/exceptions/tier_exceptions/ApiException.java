package com.what2drive.service_common.exceptions.tier_exceptions;

import com.what2drive.service_common.exceptions.WebException;

/**
 * An exception to be used in all APIs
 *
 * All your exceptions that are used in APIs must extend this exception
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:19
 */
public class ApiException extends WebException {
    public ApiException() {

    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
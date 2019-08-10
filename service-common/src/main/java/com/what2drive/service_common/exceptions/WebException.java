package com.what2drive.service_common.exceptions;

/**
 * An exception to be used in all web related services/apis
 *
 * All your exceptions must extend this exception
 *
 * @author Leo Ertuna
 * @since 20.09.2018 01:29
 */
public class WebException extends Exception {
    public WebException() {

    }

    public WebException(String message) {
        super(message);
    }

    public WebException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebException(Throwable cause) {
        super(cause);
    }

    public WebException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
package com.what2drive.service_common.exceptions.tier_exceptions;

import com.what2drive.service_common.exceptions.WebException;

/**
 * An exception to be used in all persistence services
 *
 * All your exceptions that are used in persistence services must extend this exception
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:19
 */
public class PersistenceServiceException extends WebException {
    public PersistenceServiceException() {

    }

    public PersistenceServiceException(String message) {
        super(message);
    }

    public PersistenceServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceServiceException(Throwable cause) {
        super(cause);
    }

    public PersistenceServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
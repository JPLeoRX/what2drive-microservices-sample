package com.what2drive.car_service.persistence;

import com.what2drive.service_common.exceptions.tier_exceptions.PersistenceServiceException;

public class CarPersistenceServiceException extends PersistenceServiceException {
    public CarPersistenceServiceException() {

    }

    public CarPersistenceServiceException(String message) {
        super(message);
    }

    public CarPersistenceServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarPersistenceServiceException(Throwable cause) {
        super(cause);
    }

    public CarPersistenceServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
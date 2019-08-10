package com.what2drive.car_service.persistence;

import com.what2drive.service_common.exceptions.ExceptionManager;
import org.springframework.stereotype.Service;

@Service
public class CarPersistenceServiceExceptionManager implements ExceptionManager<CarPersistenceServiceException> {
    @Override
    public CarPersistenceServiceException create() {
        return new CarPersistenceServiceException();
    }

    @Override
    public CarPersistenceServiceException create(String message) {
        return new CarPersistenceServiceException(message);
    }

    @Override
    public CarPersistenceServiceException create(Throwable cause) {
        return new CarPersistenceServiceException(cause);
    }

    @Override
    public CarPersistenceServiceException create(String message, Throwable cause) {
        return new CarPersistenceServiceException(message, cause);
    }
}
package com.what2drive.service_common.exceptions.tier_managers;

import com.what2drive.service_common.exceptions.ExceptionManager;
import com.what2drive.service_common.exceptions.tier_exceptions.ApiException;
import org.springframework.stereotype.Service;

/**
 * Default exception manager for {@link ApiException}
 *
 * If you don't want to specify your own exceptions and their manager - feel free to use this default implementation.
 * It will be more than sufficient for most projects.
 *
 * @author Leo Ertuna
 * @since 23.05.2018 23:39
 */
@Service
public class ApiExceptionManager implements ExceptionManager<ApiException> {
    @Override
    public ApiException create() {
        return new ApiException();
    }

    @Override
    public ApiException create(String message) {
        return new ApiException(message);
    }

    @Override
    public ApiException create(Throwable cause) {
        return new ApiException(cause);
    }

    @Override
    public ApiException create(String message, Throwable cause) {
        return new ApiException(message, cause);
    }
}
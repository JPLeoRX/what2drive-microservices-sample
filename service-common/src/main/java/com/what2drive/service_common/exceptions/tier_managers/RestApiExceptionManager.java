package com.what2drive.service_common.exceptions.tier_managers;

import com.what2drive.service_common.exceptions.ExceptionManager;
import com.what2drive.service_common.exceptions.tier_exceptions.RestApiException;
import org.springframework.stereotype.Service;

/**
 * Default exception manager for {@link RestApiException}
 *
 * If you don't want to specify your own exceptions and their manager - feel free to use this default implementation.
 * It will be more than sufficient for most projects.
 *
 * @author Leo Ertuna
 * @since 23.05.2018 23:39
 */
@Service
public class RestApiExceptionManager implements ExceptionManager<RestApiException> {
    @Override
    public RestApiException create() {
        return new RestApiException();
    }

    @Override
    public RestApiException create(String message) {
        return new RestApiException(message);
    }

    @Override
    public RestApiException create(Throwable cause) {
        return new RestApiException(cause);
    }

    @Override
    public RestApiException create(String message, Throwable cause) {
        return new RestApiException(message, cause);
    }
}
package com.what2drive.service_common.entities.properties;

import java.util.Date;

/**
 * This is a marker interface. It shows that this object has an updated date.
 * In this interface we force the object to provide getters and setters for this property.
 *
 * @param <D> date type of the object
 *
 * @author Leo Ertuna
 * @since 26.05.2018 17:50
 */
public interface HasDateUpdated<D extends Date> {
    /**
     * Getter for date updated
     * @return date updated
     */
    D getUpdatedAt();

    /**
     * Setter for date updated
     * @param updatedAt date updated
     */
    void setUpdatedAt(D updatedAt);
}
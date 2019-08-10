package com.what2drive.service_common.entities.properties;

import java.util.Date;

/**
 * This is a marker interface. It shows that this object has a created date.
 * In this interface we force the object to provide getters and setters for this property.
 *
 * @param <D> date type of the object
 *
 * @author Leo Ertuna
 * @since 26.05.2018 17:50
 */
public interface HasDateCreated<D extends Date> {
    /**
     * Getter for date created
     * @return date created
     */
    D getCreatedAt();

    /**
     * Setter for date created
     * @param createdAt date created
     */
    void setCreatedAt(D createdAt);
}
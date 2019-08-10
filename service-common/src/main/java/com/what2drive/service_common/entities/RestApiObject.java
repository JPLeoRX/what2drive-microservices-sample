package com.what2drive.service_common.entities;

import com.what2drive.service_common.id.AbstractId;

/**
 * This is the parent class for all Rest Api Objects (objects presented to client)
 *
 * @param <I> entity's id (although in this object it will be used as string, we need this field just to allow proper class matching)
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface RestApiObject<I extends AbstractId> extends Entity<I> {
    /**
     * Getter for id
     * @return
     */
    String getId();
}
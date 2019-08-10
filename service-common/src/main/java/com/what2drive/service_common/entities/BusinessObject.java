package com.what2drive.service_common.entities;

import com.what2drive.service_common.entities.properties.HasId;
import com.what2drive.service_common.id.AbstractId;

/**
 * This is the parent class for all Business Objects
 *
 * @param <I> entity's id
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface BusinessObject<I extends AbstractId> extends Entity<I>, HasId<I> {
    /**
     * Getter for id
     * @return
     */
    I getId();
}
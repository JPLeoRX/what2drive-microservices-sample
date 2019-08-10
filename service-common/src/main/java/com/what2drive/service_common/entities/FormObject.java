package com.what2drive.service_common.entities;

import com.what2drive.service_common.id.AbstractId;

/**
 * This is the parent class for all Form Objects (objects submitted from the client via HTTP)
 *
 * @param <I> entity's id (although in this object it will probably not be used at all, we need this field just to allow proper class matching)
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface FormObject<I extends AbstractId> extends Entity<I> {

}
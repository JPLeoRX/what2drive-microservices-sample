package com.what2drive.service_common.converters;

import com.what2drive.service_common.entities.BusinessObject;
import com.what2drive.service_common.entities.DatabaseObject;

import java.util.Collection;
import java.util.List;

/**
 * Convert from Business Objects to Database Objects
 *
 * @param <B> business object (BO)
 * @param <D> database object (DO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 13:26
 */
public interface AbstractConverterBOtoDO<B extends BusinessObject, D extends DatabaseObject> extends Converter<B, D> {
    /**
     * Convert single instance from BO to DO
     * @param businessObject business object
     * @return database object
     */
    public abstract D toDO(B businessObject);

    @Override @Deprecated
    default D convert(B b) {
        return this.toDO(b);
    }

    /**
     * Convert a collection of BO to DO
     * @param businessObjectsList collection of business objects
     * @return list of database objects
     */
    default List<D> toDO(Collection<B> businessObjectsList) {
        return this.convert(businessObjectsList);
    }
}
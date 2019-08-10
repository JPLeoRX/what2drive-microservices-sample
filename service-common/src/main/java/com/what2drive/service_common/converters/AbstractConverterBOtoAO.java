package com.what2drive.service_common.converters;

import com.what2drive.service_common.entities.ApiObject;
import com.what2drive.service_common.entities.BusinessObject;

import java.util.Collection;
import java.util.List;

/**
 * Convert from Business Objects to Api Objects
 *
 * @param <B> business object (BO)
 * @param <A> api object (AO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 11:55
 */
public interface AbstractConverterBOtoAO<B extends BusinessObject, A extends ApiObject> extends Converter<B, A> {
    /**
     * Convert single instance from BO to AO
     * @param businessObject business object
     * @return api object
     */
    public abstract A toAO(B businessObject);

    @Override @Deprecated
    default A convert(B b) {
        return this.toAO(b);
    }

    /**
     * Convert a collection of BO to AO
     * @param businessObjectsList collection of business objects
     * @return list of api objects
     */
    default List<A> toAO(Collection<B> businessObjectsList) {
        return this.convert(businessObjectsList);
    }
}
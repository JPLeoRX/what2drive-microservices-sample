package com.what2drive.service_common.converters;

import com.what2drive.service_common.entities.ApiObject;
import com.what2drive.service_common.entities.RestApiObject;

import java.util.Collection;
import java.util.List;

/**
 * Convert from Rest Api Objects to Api Objects
 *
 * @param <R> rest api object (RO)
 * @param <A> api object (AO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 11:55
 */
public interface AbstractConverterROtoAO<R extends RestApiObject, A extends ApiObject> extends Converter<R, A>  {
    /**
     * Convert single instance from RO to AO
     * @param restApiObject business object
     * @return api object
     */
    public abstract A toAO(R restApiObject);

    @Override
    default A convert(R r) {
        return this.toAO(r);
    }

    /**
     * Convert a collection of RO to AO
     * @param restApiObjectsList collection of rest api objects
     * @return list of api objects
     */
    default List<A> toAO(Collection<R> restApiObjectsList) {
        return this.convert(restApiObjectsList);
    }
}
package com.what2drive.service_common.converters;

import com.what2drive.service_common.entities.ApiObject;
import com.what2drive.service_common.entities.RestApiObject;

import java.util.Collection;
import java.util.List;

/**
 * Convert from Api Objects to Rest Api Objects
 *
 * @param <A> api object (AO)
 * @param <R> rest api object (RO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 11:55
 */
public interface AbstractConverterAOtoRO<A extends ApiObject, R extends RestApiObject> extends Converter<A, R> {
    /**
     * Convert single instance from AO to RO
     * @param apiObject api object
     * @return rest api object
     */
    public abstract R toRO(A apiObject);

    @Override @Deprecated
    default R convert(A a) {
        return this.toRO(a);
    }

    /**
     * Convert a collection of AO to RO
     * @param apiObjectsList collection of api objects
     * @return list of rest api objects
     */
    default List<R> toRO(Collection<A> apiObjectsList) {
        return this.convert(apiObjectsList);
    }
}
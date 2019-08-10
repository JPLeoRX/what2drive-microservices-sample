package com.what2drive.service_common.converters;

import com.what2drive.service_common.entities.ApiObject;
import com.what2drive.service_common.entities.BusinessObject;

import java.util.Collection;
import java.util.List;

/**
 * Convert from Api Objects to Business Objects
 *
 * @param <A> api object (AO)
 * @param <B> business object (BO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 12:44
 */
public interface AbstractConverterAOtoBO<A extends ApiObject, B extends BusinessObject> extends Converter<A, B> {
    /**
     * Convert single instance from AO to BO
     * @param apiObject api object
     * @return business object
     */
    public abstract B toBO(A apiObject);

    @Override @Deprecated
    default B convert(A a) {
        return this.toBO(a);
    }

    /**
     * Convert a collection of AO to BO
     * @param apiObjectsList collection of api objects
     * @return list of business objects
     */
    default List<B> toBO(Collection<A> apiObjectsList) {
        return this.convert(apiObjectsList);
    }
}
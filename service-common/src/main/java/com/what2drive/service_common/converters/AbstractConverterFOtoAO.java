package com.what2drive.service_common.converters;

import com.what2drive.service_common.entities.ApiObject;
import com.what2drive.service_common.entities.FormObject;

import java.util.Collection;
import java.util.List;

/**
 * Convert from Form Objects to Api Objects
 *
 * @param <F> form object (FO)
 * @param <A> api object (AO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 14:35
 */
public interface AbstractConverterFOtoAO<F extends FormObject, A extends ApiObject> extends Converter<F, A> {
    /**
     * Convert single instance from FO to AO
     * @param formObject form object
     * @return api object
     */
    public abstract A toAO(F formObject);

    @Override @Deprecated
    default A convert(F f) {
        return this.toAO(f);
    }

    /**
     * Convert a collection of FO to AO
     * @param formObjectsList collection of form objects
     * @return list of api objects
     */
    default List<A> toAO(Collection<F> formObjectsList) {
        return this.convert(formObjectsList);
    }
}
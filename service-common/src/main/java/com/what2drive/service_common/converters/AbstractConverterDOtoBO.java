package com.what2drive.service_common.converters;

import com.what2drive.service_common.entities.BusinessObject;
import com.what2drive.service_common.entities.DatabaseObject;

import java.util.Collection;
import java.util.List;

/**
 * Convert from Database Objects to Business Objects
 *
 * @param <D> database object (DO)
 * @param <B> business object (BO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 11:55
 */
public interface AbstractConverterDOtoBO<D extends DatabaseObject, B extends BusinessObject> extends Converter<D, B> {
    /**
     * Convert single instance from DO to BO
     * @param databaseObject database object
     * @return business object
     */
    public abstract B toBO(D databaseObject);

    @Override @Deprecated
    default B convert(D d) {
        return toBO(d);
    }

    /**
     * Convert a collection of DO to BO
     * @param databaseObjectsList collection of database objects
     * @return list of business objects
     */
    default List<B> toBO(Collection<D> databaseObjectsList) {
        return this.convert(databaseObjectsList);
    }
}
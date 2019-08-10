package com.what2drive.service_common.api;

import com.what2drive.service_common.biz.AbstractService;
import com.what2drive.service_common.biz.sorting.Sort;
import com.what2drive.service_common.converters.AbstractConverterAOtoBO;
import com.what2drive.service_common.converters.AbstractConverterBOtoAO;
import com.what2drive.service_common.entities.ApiObject;
import com.what2drive.service_common.entities.BusinessObject;
import com.what2drive.service_common.exceptions.ExceptionManager;
import com.what2drive.service_common.exceptions.tier_exceptions.ApiException;
import com.what2drive.service_common.exceptions.tier_exceptions.ServiceException;
import com.what2drive.service_common.id.AbstractId;

import java.util.List;
import java.util.Map;

/**
 * This class will represent an API
 *
 * All default operations from {@link AbstractService} are implemented here
 *
 * We should extend this interface and add more methods if we need any additional operations on top of default {@link AbstractService} scope
 *
 * @param <I> id of this entity
 * @param <B> business object
 * @param <A> api object
 * @param <E> exception manager
 *
 * @author Leo Ertuna
 * @since 17.05.2018 13:05
 */
public interface AbstractApi<I extends AbstractId, B extends BusinessObject<I>, A extends ApiObject<I>, E extends ExceptionManager<? extends ApiException>> {
    // Requirements
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Get a pointer to the service
     * @return service
     */
    AbstractService<I, ?, B, ?> getService();

    /**
     * Get converter from BO to AO
     * @return converter
     */
    AbstractConverterBOtoAO<B, A> getBOtoAOConverter();

    /**
     * Get converter from AO to BO
     * @return converter
     */
    AbstractConverterAOtoBO<A, B> getAOtoBOConverter();

    /**
     * Get exception manager
     * @return exception manager
     */
    E getExceptionManager();
    //------------------------------------------------------------------------------------------------------------------



    // Core methods
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Has an item in the database for this ID
     * @param id id
     * @return true if we have such item
     * @throws ApiException if {@link ServiceException} occurred
     */
    default boolean has(I id) throws ApiException {
        try {
            return getService().has(id);
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get an item from the database by its ID
     * @param id id
     * @return item
     * @throws ApiException if {@link ServiceException} occurred
     */
    default A get(I id) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().get(id));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Has some items in the database that match all given columnName/value pairs
     * @param propertiesMap map of columnName/value pairs
     * @return true if we have some items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default boolean hasByProperties(Map<String, String> propertiesMap) throws ApiException {
        try {
            return getService().hasByProperties(propertiesMap);
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Has some items in the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return true if we have some items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default boolean hasByProperty(String columnName, String value) throws ApiException {
        try {
            return getService().hasByProperty(columnName, value);
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Has  exactly one item in the database that match all given columnName/value pairs
     * @param propertiesMap map of columnName/value pairs
     * @return true if we have exactly one item
     * @throws ApiException if {@link ServiceException} occurred
     */
    default boolean hasOneEntryByProperties(Map<String, String> propertiesMap) throws ApiException {
        try {
            return getService().hasOneEntryByProperties(propertiesMap);
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Has exactly one item in the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return true if we have exactly one item
     * @throws ApiException if {@link ServiceException} occurred
     */
    default boolean hasOneEntryByProperty(String columnName, String value) throws ApiException {
        try {
            return getService().hasOneEntryByProperty(columnName, value);
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all items from the database that match all given columnName/value pairs
     * @param propertiesMap map of columnName/value pairs
     * @return list of items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default List<A> getByProperties(Map<String, String> propertiesMap) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().getByProperties(propertiesMap));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default List<A> getByProperty(String columnName, String value) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().getByProperty(columnName, value));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them sorted by rule
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @param sort sorting rule
     * @return list of items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default List<A> getByProperty(String columnName, String value, Sort<B> sort) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().getByProperty(columnName, value, sort));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all items from the database
     * @return list of all items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default List<A> getAll() throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().getAll());
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all items from the database sorted by rule
     * @param sort sorting rule
     * @return list of all items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default List<A> getAll(Sort<B> sort) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().getAll(sort));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Add item to the database
     * @param newItem item to add
     * @throws ApiException if {@link ServiceException} occurred
     */
    default A add(A newItem) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().add(getAOtoBOConverter().toBO(newItem)));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Save updated item in the database
     * @param updatedItem item to update
     * @return updated item
     * @throws ApiException if {@link ServiceException} occurred
     */
    default A update(A updatedItem) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().update(getAOtoBOConverter().toBO(updatedItem)));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Remove item from the database
     * @param id id of the item to remove
     * @return removed item
     * @throws ApiException if {@link ServiceException} occurred
     */
    default A remove(I id) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().remove(id));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Remove all items of this entity from the database
     * @return number of removed items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default int removeAll() throws ApiException {
        try {
            return getService().removeAll();
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}
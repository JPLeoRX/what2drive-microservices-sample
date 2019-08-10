package com.what2drive.service_common.biz;


import com.what2drive.service_common.biz.sorting.Sort;
import com.what2drive.service_common.converters.AbstractConverterBOtoDO;
import com.what2drive.service_common.converters.AbstractConverterDOtoBO;
import com.what2drive.service_common.entities.BusinessObject;
import com.what2drive.service_common.entities.DatabaseObject;
import com.what2drive.service_common.exceptions.ExceptionManager;
import com.what2drive.service_common.exceptions.tier_exceptions.PersistenceServiceException;
import com.what2drive.service_common.exceptions.tier_exceptions.ServiceException;
import com.what2drive.service_common.id.AbstractId;
import com.what2drive.service_common.persistence.AbstractPersistenceService;

import java.util.List;
import java.util.Map;

/**
 * This class will represent a service
 *
 * All default operations from {@link AbstractPersistenceService} are implemented here
 *
 * We should extend this interface and add more methods if we need any additional operations on top of default {@link AbstractPersistenceService} scope
 *
 * @param <I> id of this entity
 * @param <D> database object
 * @param <B> business object
 * @param <E> exception manager
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:31
 */
public interface AbstractService<I extends AbstractId, D extends DatabaseObject<I>, B extends BusinessObject<I>, E extends ExceptionManager<? extends ServiceException>> {
    // Requirements
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Get a pointer to the persistence service
     * @return persistence service
     */
    AbstractPersistenceService<I, D, ?> getPersistenceService();

    /**
     * Get converter from DO to BO
     * @return converter
     */
    AbstractConverterDOtoBO<D, B> getDOtoBOConverter();

    /**
     * Get converter from BO to DO
     * @return converter
     */
    AbstractConverterBOtoDO<B, D> getBOtoDOConverter();

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
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default boolean has(I id) throws ServiceException {
        try {
            return getPersistenceService().has(id);
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get an item from the database by its ID
     * @param id id
     * @return item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B get(I id) throws ServiceException {
        try {
            return getDOtoBOConverter().toBO(getPersistenceService().get(id));
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Has some items in the database that match all given columnName/value pairs
     * @param propertiesMap map of columnName/value pairs
     * @return true if we have some items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default boolean hasByProperties(Map<String, String> propertiesMap) throws ServiceException {
        try {
            return getPersistenceService().hasByProperties(propertiesMap);
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Has some items in the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return true if we have some items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default boolean hasByProperty(String columnName, String value) throws ServiceException {
        try {
            return getPersistenceService().hasByProperty(columnName, value);
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Has  exactly one item in the database that match all given columnName/value pairs
     * @param propertiesMap map of columnName/value pairs
     * @return true if we have exactly one item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default boolean hasOneEntryByProperties(Map<String, String> propertiesMap) throws ServiceException {
        try {
            return getPersistenceService().hasOneEntryByProperties(propertiesMap);
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Has exactly one item in the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return true if we have exactly one item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default boolean hasOneEntryByProperty(String columnName, String value) throws ServiceException {
        try {
            return getPersistenceService().hasOneEntryByProperty(columnName, value);
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all items from the database that match all given columnName/value pairs
     * @param propertiesMap map of columnName/value pairs
     * @return list of items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getByProperties(Map<String, String> propertiesMap) throws ServiceException {
        try {
            return getDOtoBOConverter().toBO(getPersistenceService().getByProperties(propertiesMap));
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getByProperty(String columnName, String value) throws ServiceException {
        try {
            return getDOtoBOConverter().toBO(getPersistenceService().getByProperty(columnName, value));
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them sorted by rule
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @param sort sorting rule
     * @return list of items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getByProperty(String columnName, String value, Sort<B> sort) throws ServiceException {
        return sort.sort(this.getByProperty(columnName, value));
    }

    /**
     * Get all items from the database
     * @return list of all items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getAll() throws ServiceException {
        try {
            return getDOtoBOConverter().toBO(getPersistenceService().getAll());
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all items from the database sorted by rule
     * @param sort sorting rule
     * @return list of all items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getAll(Sort<B> sort) throws ServiceException {
        return sort.sort(this.getAll());
    }

    /**
     * Add item to the database
     * @param newItem item to add
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B add(B newItem) throws ServiceException {
        try {
           return getDOtoBOConverter().toBO(getPersistenceService().add(getBOtoDOConverter().toDO(newItem)));
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Save updated item in the database
     * @param updatedItem item to update
     * @return updated item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B update(B updatedItem) throws ServiceException {
        try {
            return getDOtoBOConverter().toBO(getPersistenceService().update(getBOtoDOConverter().toDO(updatedItem)));
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Remove item from the database
     * @param id id of the item to remove
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B remove(I id) throws ServiceException {
        try {
            return getDOtoBOConverter().toBO(getPersistenceService().remove(id));
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Remove all items of this entity from the database
     * @return number of removed items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default int removeAll() throws ServiceException {
        try {
            return getPersistenceService().removeAll();
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}
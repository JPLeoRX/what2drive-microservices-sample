package com.what2drive.service_common.persistence;

import com.what2drive.service_common.entities.DatabaseObject;
import com.what2drive.service_common.exceptions.ExceptionManager;
import com.what2drive.service_common.exceptions.tier_exceptions.PersistenceServiceException;
import com.what2drive.service_common.id.AbstractId;
import com.what2drive.service_common.utils.Arguments;
import com.what2drive.service_common.utils.CollectionUtils;
import com.what2drive.service_common.utils.StringUtils;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * This class will represent a persistence service
 *
 * By default a persistence service must support 4 basic operation (CRUD):
 * 1) Retrieve
 * 2) Add
 * 3) Update
 * 4) Remove
 *
 * We should extend this interface and add more methods if we need any additional operations
 *
 * @param <I> id of this entity
 * @param <D> database object
 * @param <E> exception manager
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:19
 */
@Transactional
public interface AbstractPersistenceService<I extends AbstractId, D extends DatabaseObject<I>, E extends ExceptionManager<? extends PersistenceServiceException>> {
    // Requirements
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Get entity manager
     * @return entity manager
     */
    EntityManager getEntityManager();

    /**
     * Get class of DO
     * @return class
     */
    Class<D> getDatabaseObjectClass();

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
     * @throws PersistenceServiceException if some error occurred
     */
    default boolean has(String id) throws PersistenceServiceException {
        // Check whether returned object is null
        return this.get(id) != null;
    }

    /**
     * Has an item in the database for this ID
     * @param id id
     * @return true if we have such item
     * @throws PersistenceServiceException if some error occurred
     */
    default boolean has(I id) throws PersistenceServiceException {
        // Redirect to main method
        return this.has(id.getInternalId());
    }

    /**
     * Get an item from the database by its ID
     * @param id id
     * @return item
     * @throws PersistenceServiceException if some error occurred
     */
    default D get(String id) throws PersistenceServiceException {
        // Check for null arguments
        Arguments.checkForNull(id);

        // Create a query and return item from the database
        return getEntityManager().find(getDatabaseObjectClass(), id);
    }

    /**
     * Get an item from the database by its ID
     * @param id id
     * @return item
     * @throws PersistenceServiceException if some error occurred
     */
    default D get(I id) throws PersistenceServiceException {
        // Redirect to main method
        return this.get(id.getInternalId());
    }

    /**
     * Has some items in the database that match all given columnName/value pairs
     * @param propertiesMap map of columnName/value pairs
     * @return true if we have some items
     * @throws PersistenceServiceException if some error occurred
     */
    default boolean hasByProperties(Map<String, String> propertiesMap) throws PersistenceServiceException {
        // Check whether returned list is empty
        return !this.getByProperties(propertiesMap).isEmpty();
    }

    /**
     * Has some items in the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return true if we have some items
     * @throws PersistenceServiceException if some error occurred
     */
    default boolean hasByProperty(String columnName, String value) throws PersistenceServiceException {
        // Check whether returned list is empty
        return !this.getByProperty(columnName, value).isEmpty();
    }

    /**
     * Has  exactly one item in the database that match all given columnName/value pairs
     * @param propertiesMap map of columnName/value pairs
     * @return true if we have exactly one item
     * @throws PersistenceServiceException if some error occurred
     */
    default boolean hasOneEntryByProperties(Map<String, String> propertiesMap) throws PersistenceServiceException {
        // Check whether returned list has one item
        return this.getByProperties(propertiesMap).size() == 1;
    }

    /**
     * Has exactly one item in the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return true if we have exactly one item
     * @throws PersistenceServiceException if some error occurred
     */
    default boolean hasOneEntryByProperty(String columnName, String value) throws PersistenceServiceException {
        // Check whether returned list has one item
        return this.getByProperty(columnName, value).size() == 1;
    }

    /**
     * Get all items from the database that match all given columnName/value pairs
     * @param propertiesMap map of columnName/value pairs
     * @return list of items
     * @throws PersistenceServiceException if some error occurred
     */
    default List<D> getByProperties(Map<String, String> propertiesMap) throws PersistenceServiceException {
        // Check for null arguments
        Arguments.checkForNull(propertiesMap);

        // Build query string
        String queryString = "FROM " + getDatabaseObjectClass().getName() + " WHERE " + StringUtils.join(propertiesMap, " = ", " AND ", "", "'");

        // Create a query and return all items from the database
        return getEntityManager().createQuery(queryString, getDatabaseObjectClass()).getResultList();
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws PersistenceServiceException if some error occurred
     */
    default List<D> getByProperty(String columnName, String value) throws PersistenceServiceException {
        return this.getByProperties(CollectionUtils.map(columnName, value));
    }

    /**
     * Get all items from the database
     * @return list of all items
     * @throws PersistenceServiceException if some error occurred
     */
    default List<D> getAll() throws PersistenceServiceException {
        // Create a query and return all items from the database
        return getEntityManager().createQuery("FROM " + getDatabaseObjectClass().getName(), getDatabaseObjectClass()).getResultList();
    }

    /**
     * Add item to the database
     * If item with this ID already exists, throws exception
     * @param newItem item to add
     * @throws PersistenceServiceException if some error occurred
     */
    default D add(D newItem) throws PersistenceServiceException {
        // Check for null arguments
        Arguments.checkForNull(newItem);

        // If we have this entity - throw exception
        if (this.has(newItem.getId())) {
            throw getExceptionManager().create("Can't add. Object already exists for id=" + newItem.getId());
        }

        // If not
        else {
            // Add in the database
            getEntityManager().persist(newItem);

            // Retrieve new item from database
            return this.get(newItem.getId());
        }
    }

    /**
     * Save updated item in the database
     * If item with this ID doesn't exist, throws exception
     * @param updatedItem item to update
     * @return updated item
     * @throws PersistenceServiceException if some error occurred
     */
    default D update(D updatedItem) throws PersistenceServiceException {
        // Check for null arguments
        Arguments.checkForNull(updatedItem);

        // If we have this entity
        if (this.has(updatedItem.getId())) {
            // Update in the database
            return getEntityManager().merge(updatedItem);
        }

        // If not - throw exception
        else {
            throw getExceptionManager().create("Can't update. No object found to update for id=" + updatedItem.getId());
        }
    }

    /**
     * Remove item from the database
     * If item with this ID doesn't exist, throws exception
     * @param id id of the item to remove
     * @throws PersistenceServiceException if some error occurred
     */
    default D remove(I id) throws PersistenceServiceException {
        // Check for null arguments
        Arguments.checkForNull(id);

        // If we have this entity
        if (this.has(id)) {
            // Find DO
            D toDelete = this.get(id);

            // Delete in the database
            getEntityManager().remove(toDelete);

            // Return deleted item
            return toDelete;
        }

        // If not - throw exception
        else {
            throw getExceptionManager().create("Can't remove. No object found to delete for id=" + id);
        }
    }

    /**
     * Remove all items of this entity from the database
     * @return number of removed items
     * @throws PersistenceServiceException if some error occurred
     */
    default int removeAll() throws PersistenceServiceException {
        // Create a query and return the number of deleted items
        return getEntityManager().createQuery("DELETE FROM " + getDatabaseObjectClass().getName()).executeUpdate();
    }
    //------------------------------------------------------------------------------------------------------------------
}
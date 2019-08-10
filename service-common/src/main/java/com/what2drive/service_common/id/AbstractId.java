package com.what2drive.service_common.id;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class contains a core functionality of an ID
 *
 * Extend any IDs from this class, for most use cases it doesn't need any changes
 *
 * This object must be immutable, hash code is generated in constructor
 *
 * @author Leo Ertuna
 * @since 24.03.2018 13:54
 */
public abstract class AbstractId implements Serializable, Comparable<AbstractId> {
    /**
     * Internal ID string, also a string representation of this ID
     */
    private final String internalId;

    /**
     * Stored hashCode of {@link AbstractId#internalId}
     */
    private final int hashCode;

    /**
     * Main constructor
     * Creates an ID from a given internal id string
     * @param internalId id as string
     */
    protected AbstractId(String internalId) {
        if (internalId == null || internalId.isEmpty())
            throw new IllegalArgumentException();
        this.internalId = internalId;
        this.hashCode = internalId.hashCode();
    }

    /**
     * Shortened constructor
     * Creates an ID with a newly generated internal id string
     */
    protected AbstractId() {
        this(IdGenerator.generateUniqueRandomId());
    }

    /**
     * Getter
     * @return id as string
     */
    public String getInternalId() {
        return internalId;
    }

    @Override
    public int compareTo(AbstractId o) {
        return this.getInternalId().compareTo(o.getInternalId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractId that = (AbstractId) o;
        return Objects.equals(internalId, that.internalId);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        return internalId;
    }
}
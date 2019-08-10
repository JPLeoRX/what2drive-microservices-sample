package com.what2drive.service_common.id;

import java.util.UUID;

/**
 * This class contains only one static method that should be used for generating new ID strings
 *
 * The class is static and final
 *
 * @author Leo Ertuna
 * @since 24.03.2018 13:54
 */
public final class IdGenerator {
    /**
     * Private default constructor
     * Prevents instantiation of this class
     */
    private IdGenerator() {
        throw new IllegalAccessError();
    }

    /**
     * Generate new ID string
     * @return random string
     */
    public static String generateUniqueRandomId() {
        return UUID.randomUUID().toString();
    }
}
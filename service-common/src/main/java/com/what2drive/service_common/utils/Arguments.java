package com.what2drive.service_common.utils;

import java.util.Arrays;

public final class Arguments {
    public static void checkForNull(Object ... arguments) {
        for (Object argument : arguments)
            if (argument == null)
                throw new ArgumentsAreNullException("arguments=" + Arrays.toString(arguments));
    }
}
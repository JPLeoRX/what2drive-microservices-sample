package com.what2drive.service_common.utils;

public class Validator {
    public static boolean isAscii(String s) {
        return s.matches("^[ -~]*$");
    }

    public static boolean isEmail(String s) {
        return s.contains("@");
    }

    public static boolean isUsername(String s) {
        boolean isInvalidLength = s.length() > 30;
        boolean hasInvalid = s.contains(",") || s.contains(";") || s.contains(":") || s.contains("!")  || s.contains("#") || s.contains(" ") || s.contains("\\n");
        return isAscii(s) && !isEmail(s) && !hasInvalid && !isInvalidLength;
    }
}
package com.what2drive.service_common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StringUtils {
    public static final String WORD_DELIM = ",";
    public static final String TEXT_DELIM = "|SPECIAL_DELIM|";

    public static List<String> split(String s, String deliminator) {
        if (s.isEmpty())
            return new ArrayList<>();
        return Arrays.asList(s.split(deliminator.replace("|", "\\|")));
    }

    /**
     * Join several strings in one
     * @param words strings to be joined
     * @param deliminator deliminator is put after each next word
     * @return joined string
     */
    public static String join(List<String> words, String deliminator) {
        // If the list exists and it's not empty
        if (words != null && !words.isEmpty()) {
            // Create new string
            String joined = "";

            // Join words in it with added deliminator
            for (String word : words)
                joined += word + deliminator;

            // Remove the last deliminator
            joined = joined.substring(0, joined.length() - deliminator.length());

            // Return resulting string
            return joined;
        }

        // If there's something wrong with the list - throw an exception
        else {
            return "";
        }
    }

    /**
     * Join map in a string
     * @param map
     * @param equalsDeliminator
     * @param pairsDeliminator
     * @return
     */
    public static String join(Map<String, String> map, String equalsDeliminator, String pairsDeliminator) {
        return join(map, equalsDeliminator, pairsDeliminator, "", "");
    }

    /**
     * Join map in a string
     * @param map
     * @param equalsDeliminator
     * @param pairsDeliminator
     * @param keyWrap
     * @param valueWrap
     * @return
     */
    public static String join(Map<String, String> map, String equalsDeliminator, String pairsDeliminator, String keyWrap, String valueWrap) {
        // If the map exists and it's not empty
        if (map != null && !map.isEmpty()) {
            // Create new string
            String joined = "";

            // Join key-pair in it with added deliminators
            for (Map.Entry<String, String> entry : map.entrySet())
                joined += keyWrap + entry.getKey() + keyWrap + equalsDeliminator + valueWrap + entry.getValue() + valueWrap + pairsDeliminator;

            // Remove the last deliminator
            joined = joined.substring(0, joined.length() - pairsDeliminator.length());

            // Return resulting string
            return joined;
        }

        // If there's something wrong with the map - return empty string
        else {
            return "";
        }
    }

    /**
     *
     * @param str
     * @param subStr
     * @return
     */
    public static int countOccurrences(String str, String subStr) {
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = str.indexOf(subStr, lastIndex);

            if(lastIndex != -1){
                count++;
                lastIndex += subStr.length();
            }
        }

        return count;
    }
}

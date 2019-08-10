package com.what2drive.service_common.utils;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <O> List<O> merge(List<O> l1, List<O> l2) {
        List<O> merged = new ArrayList<>(l1.size() + l2.size());
        merged.addAll(l1);
        merged.addAll(l2);
        return merged;
    }

    public static <O> List<O> exclude(List<O> l1, List<O> toExclude) {
        List<O> excluded = new ArrayList<>(l1.size() - toExclude.size());
        for (O e : l1)
            if (!toExclude.contains(e))
                excluded.add(e);
        return excluded;
    }

    public static <O> List<O> exclude(List<O> l1, O toExclude) {
        return exclude(l1, Arrays.asList(toExclude));
    }

    public static <K, V> HashMap<K, V> map(K key, V value) {
        HashMap<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    public static <K, V> HashMap<K, V> map(K k1, V v1, K k2, V v2) {
        HashMap<K, V> map = new HashMap<>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static long getClosestTimestamp(List<Long> list, long timestamp) {
        if (list.isEmpty())
            return -1;

        return list.stream().min(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                long diff1 = Math.abs(o1 - timestamp);
                long diff2 = Math.abs(o2 - timestamp);
                return Long.compare(diff1, diff2);
            }
        }).get();
    }

    public static <V> List<Long> getTimestampKeysInRange(Map<Long, V> map, long start, long end) {
        return map.keySet().stream().filter(k -> start < k && k < end).collect(Collectors.toList());
    }

    public static long getLowestTimestampKey(Map<Long, ?> ... maps) {
        if (maps == null || maps.length == 0)
            throw new IllegalArgumentException();

        List<Long> allKeys = new ArrayList<>(maps.length * maps[0].keySet().size());
        for (Map<Long, ?> map : maps)
            allKeys.addAll(map.keySet());
        return allKeys.stream().mapToLong(l -> l).min().getAsLong();
    }

    public static long getHighestTimestampKey(Map<Long, ?> ... maps) {
        if (maps == null || maps.length == 0)
            throw new IllegalArgumentException();

        List<Long> allKeys = new ArrayList<>(maps.length * maps[0].keySet().size());
        for (Map<Long, ?> map : maps)
            allKeys.addAll(map.keySet());
        return allKeys.stream().mapToLong(l -> l).max().getAsLong();
    }

    public static <V> V getByClosestTimestampInRange(Map<Long, V> map, long start, long end, long timestamp) {
        List<Long> keysInRange = getTimestampKeysInRange(map, start, end);
        long closestTimestamp = getClosestTimestamp(keysInRange, timestamp);
        if (closestTimestamp == -1)
            return null;
        return map.getOrDefault(closestTimestamp, null);
    }
}
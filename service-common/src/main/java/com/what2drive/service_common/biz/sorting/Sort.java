package com.what2drive.service_common.biz.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is a simple sort interface. It will allow easier sorting of lists.
 * We will use parallel streams to achieve adequate performance without getting our hands dirty.
 *
 * @param <E> object to compare
 *
 * @author Leo Ertuna
 * @since 26.05.2018 17:30
 */
public interface Sort<E> {
    /**
     * Compares two arguments for order
     * Must returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second
     * For more details see {@link Comparator#compare(Object, Object)}
     * @param o1 the first object to be compared
     * @param o2 the second object to be compared
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    int compare(E o1, E o2);

    /**
     * Creates a {@link Comparator} object based on this interface and current {@link Sort#compare(Object, Object)} method
     * @return the corresponding comparator
     */
    default Comparator<E> getComparator() {
        return (o1, o2) -> compare(o1, o2);
    }

    /**
     * Sorts the list
     * We use streams for sorting - so the returned list is a copy of the original one
     * @param list list to sort
     * @return sorted list
     */
    default List<E> sort(List<E> list) {
        return list.parallelStream().sorted(this.getComparator()).collect(Collectors.toList());
    }

    /**
     * Get reversed sorter
     * @return new reversed sorter
     */
    default Sort<E> getReversedSort() {
        return new Sort<E>() {
            @Override
            public int compare(E o1, E o2) {
                return -1 * Sort.this.compare(o1, o2);
            }
        };
    }
}
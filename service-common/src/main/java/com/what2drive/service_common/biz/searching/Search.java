package com.what2drive.service_common.biz.searching;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple search interface. It'll provide easy plug-and-play searching options.
 * We will use parallel streams and filters to achieve adequate performance without getting our hands dirty.
 *
 * @param <E> generic type of the searched object
 *
 * @author Leo Ertuna
 * @since 28.05.2018 16:42
 */
public interface Search<E> {
    /**
     * Search criteria
     * @param e analyzed object
     * @return true if this object matches your desired search criteria, false otherwise
     */
    boolean criteria(E e);

    /**
     * If our collection is larger than this value - parallelized search will take place
     * Override this method if you need to tweak performance
     * @return parallelism threshold size
     */
    default int getParallelismThreshold() {
        return 1000;
    }

    /**
     * Find all objects that match a given criteria in the list
     * @param list list of objects
     * @return list of all objects that matched
     */
    default List<E> search(List<E> list) {
        // If it is greater than threshold size - run it through a parallel stream
        if (list.size() > this.getParallelismThreshold()) {
            return list.parallelStream().filter(this::criteria).collect(Collectors.toList());
        }

        // If not - use classic for loop (it will run faster than single threaded stream)
        else {
            // Create new list
            List<E> results = new LinkedList<>();

            // For each existing object
            for (E object : list)
                // If it matches the criteria
                if (this.criteria(object))
                    // Save it in new list
                    results.add(object);

            // Return resulting list
            return results;
        }
    }
}
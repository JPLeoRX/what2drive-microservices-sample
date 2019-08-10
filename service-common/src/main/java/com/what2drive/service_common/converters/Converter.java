package com.what2drive.service_common.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter's jod is to seamlessly switch from one object to another
 *
 * This object stays at highest level of abstraction
 *
 * Converters must take full responsibility for changing entity's type. They can become quite complicated too.
 * If you need any additional APIs/services to make the conversion - {@link Autowired} them here.
 * Converters can be considered services, so for better performance you can mark them as {@link Service} and make them {@link Autowired} in your services/APIs.
 *
 * @param <From> object from
 * @param <To> object to
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:54
 */
public interface Converter<From, To> extends Serializable {
    /**
     * Convert single instance
     * @param from from object
     * @return to object
     */
    public abstract To convert(From from);

    /**
     * Convert a collection
     * @param froms from objects
     * @return to objects
     */
    default List<To> convert(Collection<From> froms) {
        // If it is greater than threshold size - run it through a parallel stream
        if (froms.size() > this.getParallelismThreshold()) {
            return froms.parallelStream().map(this::convert).collect(Collectors.toList());
        }

        // If not - use classic for loop (it will run faster than single threaded stream)
        else {
            ArrayList<To> tos = new ArrayList<>(froms.size());
            for (From from : froms)
                tos.add(this.convert(from));
            return tos;
        }
    }

    /**
     * If our collection is larger than this value - parallelized conversions will take place
     * Override this method if you need to tweak performance
     * @return parallelism threshold size
     */
    default int getParallelismThreshold() {
        return 10000;
    }
}
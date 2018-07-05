package org.practice.spitter.data;

import org.practice.spitter.Spittle;

import java.util.List;

public interface SpittleRepository {
    /**
     * Get list of spittle with {@code id <= max} and {@code sizeOfReturnedList <= count}
     *
     * @param max   maxID (def = Long.MAX_VALUE)
     * @param count max amount of spittles returned in list (def = 20)
     * @return unordered list of spittles
     */
    List<Spittle> findSpittles(long max, int count);
}

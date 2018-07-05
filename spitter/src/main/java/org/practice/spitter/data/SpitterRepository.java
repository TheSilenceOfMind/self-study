package org.practice.spitter.data;

import org.practice.spitter.Spitter;

public interface SpitterRepository {
    /**
     * Save unregistered user (simply "register" that user).
     *
     * @param spitter user to register.
     * @return registered user with specified ID in the social network.
     * @throws IllegalArgumentException if given spitter is null.
     */
    Spitter save(Spitter spitter) throws IllegalArgumentException;

    /**
     * Find Spitter by username.
     *
     * @param username username
     * @return Spitter object. If no such, return null.
     */
    Spitter findByUsername(String username);
}

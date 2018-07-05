package org.practice.spitter.data;

import org.practice.spitter.Spitter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class SimpleSpitterRepository implements SpitterRepository {

    private Set<Spitter> spitterSet;

    public SimpleSpitterRepository(final Set<Spitter> set) {
        spitterSet = set;
    }

    @Override
    public Spitter save(Spitter spitter) throws IllegalArgumentException {
        if (spitter == null)
            throw new IllegalArgumentException("The argument shouldn't be null");

        Long freeId = (long) spitterSet.size();
        Spitter createdSpitter = new Spitter(freeId, spitter);
        spitterSet.add(createdSpitter);

        return createdSpitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        for (Spitter spitter : spitterSet)
            if (spitter.getUsername().equals(username))
                return spitter;
        return null;
    }

    public Set<Spitter> getSpitterSet() {
        return spitterSet;
    }
}

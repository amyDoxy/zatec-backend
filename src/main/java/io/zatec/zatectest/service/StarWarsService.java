package io.zatec.zatectest.service;

import io.zatec.zatectest.data.StarWarsPeople;

import java.util.Collection;

/**
 * Service class for Star Wars operations
 *
 * @author amy.muhimpundu
 */
public interface StarWarsService {

    /**
     * Retrieve Star Wars people
     *
     * @return a collection of {@link StarWarsPeople}
     */
    Collection<StarWarsPeople> retrievePeople();
}

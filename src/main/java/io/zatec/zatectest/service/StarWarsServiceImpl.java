package io.zatec.zatectest.service;

import io.zatec.zatectest.data.StarWarsPeople;
import io.zatec.zatectest.gateway.StarWarsServiceGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Service implementation of {@link StarWarsService}
 *
 * @author amy.muhimpundu
 */
@Slf4j @Service @RequiredArgsConstructor public class StarWarsServiceImpl implements StarWarsService {

    private final StarWarsServiceGateway gateway;

    @Override public Collection<StarWarsPeople> retrievePeople() {
        log.debug("Inside retrievePeople");
        return gateway.fetchPeople().block().getResults();
    }
}

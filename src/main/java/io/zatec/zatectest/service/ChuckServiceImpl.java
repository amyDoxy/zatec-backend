package io.zatec.zatectest.service;

import io.zatec.zatectest.data.JokeResponse;
import io.zatec.zatectest.gateway.ChuckNorrisServiceGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;

/**
 * Service implementation of {@link ChuckService}
 *
 * @author amy.muhimpundu
 */
@Slf4j @Validated @Service @RequiredArgsConstructor public class ChuckServiceImpl implements ChuckService {

    private final ChuckNorrisServiceGateway gateway;

    @Override public Collection<String> retrieveJokeCategories() {
        log.debug("Inside retrieveJokeCategories");
        return gateway.fetchJokeCategories().block();
    }

    @Override public JokeResponse fetchRandomJokeByCategory(String category) {
        log.debug("Inside fetchRandomJokeByCategory");
        return gateway.fetchRandomJokeByCategory(category).block();
    }
}

package io.zatec.zatectest.gateway;

import io.zatec.zatectest.data.StarWarsPeopleWrappedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Gateway to Star Wars service
 *
 * @author amy.muhimpundu
 */
@Component @RequiredArgsConstructor public class StarWarsServiceGateway {

    private final WebClient.Builder webClientBuilder;
    @Value("${star-wars.base-url}") private String starWarsBaseURL;
    @Value("${star-wars.people-endpoint}") private String starWarsPeopleEndpoint;

    //TODO: Add Spring Retry
    public Mono<StarWarsPeopleWrappedResponse> fetchPeople() {
        return webClientBuilder.build().get().uri(starWarsBaseURL + starWarsPeopleEndpoint).retrieve()
                .bodyToMono(StarWarsPeopleWrappedResponse.class);
    }
}

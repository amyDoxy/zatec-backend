package io.zatec.zatectest.gateway;

import io.zatec.zatectest.data.JokeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Gateway to Chuck Norris service
 *
 * @author amy.muhimpundu
 */
@Slf4j @Component @Validated @RequiredArgsConstructor public class ChuckNorrisServiceGateway {

    private final WebClient.Builder webClientBuilder;
    @Value("${chuck-norris.base-url}") private String chuckNorrisBaseURL;
    @Value("${chuck-norris.categories-endpoint}") private String categoriesEndpoint;
    @Value("${chuck-norris.joke-endpoint}") private String jokeEndpoint;

    //TODO: Add Spring Retry
    public Mono<List> fetchJokeCategories() {
        return webClientBuilder.build().get().uri(chuckNorrisBaseURL + categoriesEndpoint).retrieve().bodyToMono(List.class);
    }

    //TODO: Add Spring Retry
    public Mono<JokeResponse> fetchRandomJokeByCategory(@NotBlank String category) {
        return webClientBuilder.build().get().uri(chuckNorrisBaseURL + jokeEndpoint + "?category=" + category).retrieve()
                .bodyToMono(JokeResponse.class);
    }
}

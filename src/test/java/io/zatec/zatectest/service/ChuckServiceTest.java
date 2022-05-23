package io.zatec.zatectest.service;

import io.zatec.zatectest.shared.AbstractSharedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolationException;
import java.util.stream.Stream;

import static io.zatec.zatectest.utils.MessageConstants.CATEGORY_MANDATORY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test class for {@link ChuckService}
 */
class ChuckServiceTest extends AbstractSharedTest {

    @Autowired private ChuckService chuckService;

    /**
     * Method that generate arguments for retrieve joke by category
     *
     * @return a set of test arguments
     */
    static Stream<Arguments> retrieveJokeProvider() {

        return Stream.of(arguments(null, ConstraintViolationException.class, CATEGORY_MANDATORY),
                arguments(" ", ConstraintViolationException.class, CATEGORY_MANDATORY));
    }

    @BeforeEach void setup() {
    }

    @Test void testCallChuckNorrisCategoriesAPI() {
        //TODO:add mock for MockWebServer
        assertThat(chuckService.retrieveJokeCategories()).isNotEmpty();
    }

    @ParameterizedTest @MethodSource("retrieveJokeProvider") @DisplayName("Test retrieve joke with multiple arguments") <T extends RuntimeException> void testRetrieveJoke_withInvalidArguments(
            String category, Class<T> expectedException, String expectedMsg) {
        assertThatThrownBy(() -> chuckService.fetchRandomJokeByCategory(category)).isInstanceOf(expectedException)
                .hasMessageContaining(expectedMsg);
    }

}
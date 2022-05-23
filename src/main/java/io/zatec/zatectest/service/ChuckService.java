package io.zatec.zatectest.service;

import io.zatec.zatectest.data.JokeResponse;

import javax.validation.constraints.NotBlank;
import java.util.Collection;

import static io.zatec.zatectest.utils.MessageConstants.CATEGORY_MANDATORY;

/**
 * Service class for Chuck Norris operations
 *
 * @author amy.muhimpundu
 */
public interface ChuckService {

    /**
     * Retrieve joke categories
     *
     * @return a collection of categories
     */
    Collection<String> retrieveJokeCategories();

    /**
     * Fetch random joke by category
     *
     * @param category the category
     * @return {@link JokeResponse}
     */
    JokeResponse fetchRandomJokeByCategory(@NotBlank(message = CATEGORY_MANDATORY) String category);
}

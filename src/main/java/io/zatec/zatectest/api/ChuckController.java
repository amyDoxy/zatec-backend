package io.zatec.zatectest.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.zatec.zatectest.data.JokeResponse;
import io.zatec.zatectest.service.ChuckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Collection;

import static io.zatec.zatectest.utils.MessageConstants.CATEGORY_MANDATORY;

/**
 * Class exposing REST endpoints for categories related operations
 *
 * @author amy.muhimpundu
 */
@CrossOrigin(origins = "*", allowedHeaders = "*") @Slf4j @Validated @RestController @RequiredArgsConstructor @RequestMapping("/chuck") public class ChuckController {

    private final ChuckService chuckService;

    @GetMapping("/categories") @ResponseStatus(HttpStatus.OK) @Operation(summary = "List categories", description = "Retrieve the list of categories") @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = OpenApiResource.GetCategoriesResponse.class)))) }) public Collection<String> retrieveCategories() {
        log.debug("Inside ChuckController::retrieveCategories");
        return chuckService.retrieveJokeCategories();
    }

    @GetMapping("joke") @ResponseStatus(HttpStatus.OK) @Operation(summary = "List categories", description = "Retrieve the list of categories") @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = OpenApiResource.GetCategoriesResponse.class)))) }) public JokeResponse fetchJokeByCategory(
            @RequestParam @NotBlank(message = CATEGORY_MANDATORY) String category) {
        log.debug("Inside ChuckController::fetchJokeByCategory");

        return chuckService.fetchRandomJokeByCategory(category);
    }
}

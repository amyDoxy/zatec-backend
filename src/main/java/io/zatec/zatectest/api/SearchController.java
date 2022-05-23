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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Class exposing REST endpoints for search related operations
 *
 * @author amy.muhimpundu
 */
@Slf4j @RestController @RequiredArgsConstructor @RequestMapping("/search") public class SearchController {

    private final ChuckService chuckService;

    @GetMapping @ResponseStatus(HttpStatus.OK) @Operation(summary = "Perform a search", description = "Perform simultaneously search both the Chuck Norris and Star Wars API") @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = OpenApiResource.GetCategoriesResponse.class)))) }) public Collection<JokeResponse> search() {
        log.debug("Inside SearchController::search");
        return null;
    }
}

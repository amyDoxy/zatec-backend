package io.zatec.zatectest.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.zatec.zatectest.data.StarWarsPeople;
import io.zatec.zatectest.service.StarWarsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Class exposing REST endpoints for Star Wars people related operations
 *
 * @author amy.muhimpundu
 */
@CrossOrigin(origins = "*", allowedHeaders = "*") @Slf4j @RestController @RequiredArgsConstructor @RequestMapping("/swapi") public class SwapiController {

    private final StarWarsService starWarsService;

    @GetMapping("/people") @ResponseStatus(HttpStatus.OK) @Operation(summary = "List Star Wars people", description = "Retrieve the list of Star Wars people") @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = OpenApiResource.GetSwapiPeopleResponse.class)))) }) public Collection<StarWarsPeople> retrieveSwaPeople() {
        log.debug("Inside SwapiController::retrieveSwaPeople");
        return starWarsService.retrievePeople();
    }
}

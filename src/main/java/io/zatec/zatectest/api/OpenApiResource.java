package io.zatec.zatectest.api;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class OpenApiResource {

    private OpenApiResource() {
    }

    @Schema(description = "GetJokeResponse") public static final class GetJokeResponse {

        @Schema(example = "http:/") public String url;
        @Schema(example = "Test") public String value;
        private GetJokeResponse() {

        }
    }

    @Schema(description = "GetSwapiPeopleResponse") public static final class GetSwapiPeopleResponse {

        @Schema(example = "Arsene Lupi") public String name;
        @Schema(example = "178") private Long height;
        @Schema(example = "89") private Long mass;
        private List<String> films;
        private GetSwapiPeopleResponse() {

        }
    }
}

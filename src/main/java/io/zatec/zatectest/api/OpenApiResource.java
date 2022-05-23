package io.zatec.zatectest.api;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class OpenApiResource {

    private OpenApiResource() {
    }

    @Schema(description = "GetCategoriesResponse") public static final class GetCategoriesResponse {

        private GetCategoriesResponse() {

        }

        @Schema(example = "1") public Long id;
        @Schema(example = "Test") public String name;
    }

    @Schema(description = "GetSwapiPeopleResponse") public static final class GetSwapiPeopleResponse {

        private GetSwapiPeopleResponse() {

        }

        @Schema(example = "Arsene Lupi") public String name;
        @Schema(example = "178") private Long height;
        @Schema(example = "89") private Long mass;
        private List<String> films;
    }
}

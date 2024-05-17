package com.rosendo.challengeliteralura.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BooksAuthorsDto(
        @JsonProperty("name")
        String name,

        @JsonProperty("birth_year")
        String birthYear,

        @JsonProperty("death_year")
        String deathYear
) {
}

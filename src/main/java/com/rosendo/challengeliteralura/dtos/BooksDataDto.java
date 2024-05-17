package com.rosendo.challengeliteralura.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BooksDataDto(
        @JsonProperty("results")
        List<BooksDto> results
) { }

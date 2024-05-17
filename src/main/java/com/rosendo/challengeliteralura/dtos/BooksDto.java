package com.rosendo.challengeliteralura.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BooksDto(
        @JsonProperty("title")
        String title,

        @JsonProperty("authors")
        List<BooksAuthorsDto> authors,

        @JsonProperty("languages")
        List<String> languages,

        @JsonProperty("download_count")
        Long downloadCount
) {}

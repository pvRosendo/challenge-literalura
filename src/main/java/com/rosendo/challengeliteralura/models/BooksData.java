package com.rosendo.challengeliteralura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksData {

        @JsonProperty("results")
        private List<BooksModel> results;

        public List<BooksModel> getResults() {
                return results;
        }

        public void setResults(List<BooksModel> results) {
                this.results = results;
        }
}

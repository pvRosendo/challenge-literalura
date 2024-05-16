package com.rosendo.challengeliteralura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksModel {

        @JsonProperty("id")
        private int id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("authors")
        private List<Object> authors;
        @JsonProperty("languages")
        private List<String> languages;
        @JsonProperty("download_count")
        private Long downloadCount;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public List<Object> getAuthors() {
                return authors;
        }

        public void setAuthors(List<Object> authors) {
                this.authors = authors;
        }

        public List<String> getLanguages() {
                return languages;
        }

        public void setLanguages(List<String> languages) {
                this.languages = languages;
        }

        public Long getDownloadCount() {
                return downloadCount;
        }

        public void setDownloadCount(Long downloadCount) {
                this.downloadCount = downloadCount;
        }
}

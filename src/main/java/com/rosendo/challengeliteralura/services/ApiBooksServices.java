package com.rosendo.challengeliteralura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rosendo.challengeliteralura.controllers.ApiBooksController;
import com.rosendo.challengeliteralura.models.BooksData;

import java.util.List;
import java.util.Scanner;

public class ApiBooksServices {

    private static final String URI_SEARCH_BY_TITLE = "?search=";
    Scanner reading = new Scanner(System.in);

    public void searchBookByTitle() throws JsonProcessingException {
        ApiBooksController controller = new ApiBooksController();

        System.out.println("What's the book that you is searching for?");
        String nameBook = reading.nextLine().replaceAll(" ", "%20");
        String json = controller.consumeApi(URI_SEARCH_BY_TITLE + nameBook);
        System.out.println(json);
        receiveData(json);
    }

    public void receiveData(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        BooksData bookData = mapper.readValue(json, BooksData.class);

        if (bookData.getResults() != null && !bookData.getResults().isEmpty()) {
            String title = bookData.getResults().get(0).getTitle();
            List<Object> authors = bookData.getResults().get(0).getAuthors();
            List<String> languages = bookData.getResults().get(0).getLanguages();
            Long downloads = bookData.getResults().get(0).getDownloadCount();

            System.out.println("Title: " + title);
            System.out.println("authors: " + authors);
            System.out.println("languages: " + languages);
            System.out.println("downloads: " + downloads);
        } else {
            System.out.println("No info data found.");
        }
    }
}

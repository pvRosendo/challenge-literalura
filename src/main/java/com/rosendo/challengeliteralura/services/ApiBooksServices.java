package com.rosendo.challengeliteralura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rosendo.challengeliteralura.controllers.ApiBooksController;
import com.rosendo.challengeliteralura.models.ApiBooksMenu;
import com.rosendo.challengeliteralura.models.BooksAuthorsModel;
import com.rosendo.challengeliteralura.models.BooksData;

import java.util.Arrays;
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
        ApiBooksMenu texts = new ApiBooksMenu();

        BooksData bookData = mapper.readValue(json, BooksData.class);

        if (bookData.getResults() != null && !bookData.getResults().isEmpty()) {
            String title = bookData.getResults().get(0).getTitle();
            List<BooksAuthorsModel> authors = bookData.getResults().get(0).getAuthors();
            String firstAuthor = "";
            List<String> languages = bookData.getResults().get(0).getLanguages();
            Long downloads = bookData.getResults().get(0).getDownloadCount();

            if (authors != null && !authors.isEmpty() && authors.get(0).getName() != null) {
                String[] authorParts = authors.get(0).getName().split(",");
                if (authorParts.length > 0) {
                    firstAuthor = authorParts[0].trim();
                }
            }

            texts.responseInfo(title, firstAuthor, languages.get(0), downloads);
        } else {
            System.out.println("No info data found.");
        }
    }
}

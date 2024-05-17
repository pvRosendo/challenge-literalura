package com.rosendo.challengeliteralura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rosendo.challengeliteralura.controllers.ApiBooksController;
import com.rosendo.challengeliteralura.dtos.BooksAuthorsDto;
import com.rosendo.challengeliteralura.dtos.BooksDataDto;
import com.rosendo.challengeliteralura.models.ApiBooksMenu;

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

        BooksDataDto bookData = mapper.readValue(json, BooksDataDto.class);

        if (bookData.results() != null && !bookData.results().isEmpty()) {
            String title = bookData.results().get(0).title();
            List<BooksAuthorsDto> authors = bookData.results().get(0).authors();
            String firstAuthor = "";
            List<String> languages = bookData.results().get(0).languages();
            Long downloads = bookData.results().get(0).downloadCount();

            if (authors != null && !authors.isEmpty() && authors.get(0).name() != null) {
                String[] authorParts = authors.get(0).name().split(",");
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

package com.rosendo.challengeliteralura.services;

import com.rosendo.challengeliteralura.controllers.ApiBooksController;

import java.util.Scanner;

public class ApiBooksServices {

    private static final String URI_SEARCH_BY_TITLE = "?search=";
    Scanner lecture = new Scanner(System.in);

    public void searchBookByTitle() {
        ApiBooksController controller = new ApiBooksController();

        System.out.println("What's the book that you is searching for?");
        String nameBook = lecture.nextLine().replaceAll(" ", "%20");
        controller.consumeApi(URI_SEARCH_BY_TITLE + nameBook);

    }
}

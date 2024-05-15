package com.rosendo.challengeliteralura.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiBooksController {

    private static final URI LINK_API_CONVERTER = URI.create("https://gutendex.com/books/");

    HttpClient client;

    public String consumeApi() {

        client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(LINK_API_CONVERTER)
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {

            throw new RuntimeException(e);

        }

        return response.body();
    }

}

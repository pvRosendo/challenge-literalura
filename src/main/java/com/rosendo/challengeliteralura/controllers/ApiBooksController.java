package com.rosendo.challengeliteralura.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiBooksController {

    private static final String LINK_API_CONVERTER = "https://gutendex.com/books/";

    HttpClient client;

    public String consumeApi(String uri) {

        client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(LINK_API_CONVERTER + uri))
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

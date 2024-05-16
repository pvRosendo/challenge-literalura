package com.rosendo.challengeliteralura.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiBooksController {

    private static final String LINK_API_CONVERTER = "https://gutendex.com/books/";

    HttpClient client;

    public void consumeApi(String uri) {

        client = HttpClient.newHttpClient();

        System.out.println("cheguei antes do request");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(LINK_API_CONVERTER + uri))
                .build();

        System.out.println("passei do request com a uri = " + LINK_API_CONVERTER + uri);
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("tentei fazer o request e a response é: " + response);
        } catch (IOException | InterruptedException e) {

            throw new RuntimeException(e);

        }
        System.out.println(response.body());
    }

}

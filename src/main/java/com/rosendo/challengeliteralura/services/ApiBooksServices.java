package com.rosendo.challengeliteralura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rosendo.challengeliteralura.controllers.ApiBooksController;
import com.rosendo.challengeliteralura.dtos.BooksAuthorsDto;
import com.rosendo.challengeliteralura.dtos.BooksDataDto;
import com.rosendo.challengeliteralura.models.AuthorModel;
import com.rosendo.challengeliteralura.models.BooksModel;
import com.rosendo.challengeliteralura.repository.AuthorRepository;
import com.rosendo.challengeliteralura.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ApiBooksServices {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BooksRepository booksRepository;

    private static final String URI_SEARCH_BY_TITLE = "?search=";
    private Integer exitVariable = -1;
    private final Scanner reading = new Scanner(System.in);
    private final Scanner reading2 = new Scanner(System.in);


    public void consumeApiSearchingByTitle() throws JsonProcessingException {
        ApiBooksController controller = new ApiBooksController();

        System.out.println("What's the book that you is searching for?");
        String nameBook = reading.nextLine().replaceAll(" ", "%20");
        String json = controller.consumeApi(URI_SEARCH_BY_TITLE + nameBook);
        System.out.println(json);
        receiveData(json);
    }

    public void receiveData(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        BooksDataDto bookData = mapper.readValue(json, BooksDataDto.class);

        if (bookData.results() != null && !bookData.results().isEmpty()) {
            String title = bookData.results().get(0).title();
            List<BooksAuthorsDto> authors = bookData.results().get(0).authors();
            List<String> languages = bookData.results().get(0).languages();
            Long downloads = bookData.results().get(0).downloadCount();

            String firstAuthor = "";
            if (authors != null && !authors.isEmpty() && authors.get(0).name() != null) {
                String[] authorParts = authors.get(0).name().split(",");
                if (authorParts.length > 0) {
                    firstAuthor = authorParts[0].trim();
                }
            }
            responseInfo(title, firstAuthor, languages.get(0), downloads);

            System.out.println(authorRepository);
            List<BooksModel> listOfBooks = new ArrayList<>();

            AuthorModel author = new AuthorModel(
                    firstAuthor,
                    authors.get(0).birthYear(),
                    authors.get(0).deathYear(),
                    listOfBooks
            );

            BooksModel book = new BooksModel(title, author , languages.get(0), downloads);
            listOfBooks.add(book);

            authorRepository.save(author);
            booksRepository.save(book);

        } else {
            System.out.println("No info data found.");
        }
    }

    public void runApp() throws JsonProcessingException {

        while (exitVariable != 0) {
            System.out.println("""
                            -----------------------------------------------
                            Choose your desired option
                            -----------------------------------------------
                            
                            1 - Search for book by title;
                            2 - List registered books;
                            3 - List registered authors;
                            4 - List living authors in a given year;
                            5 - List books in a given language;
                            0 - quit
                            
                            """);

            switch (reading2.nextLine()){
                case "1":
                    consumeApiSearchingByTitle();
                    break;

                case "2":
                    System.out.println("option 2");
                    break;

                case "3":
                    System.out.println("option 3");
                    break;

                case "4":
                    System.out.println("option 4");
                    break;

                case "5":
                    System.out.println("option 5");
                    break;

                case "0":
                    exitVariable = 0;
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    public void responseInfo(String title, Object authors, String languages, Long downloads) {
        System.out.println(
                "\n========================= " +
                        "Informations of " + title +
                        " ========================="
        );

        System.out.println("Title: " + title);
        System.out.println("authors: " + authors);
        System.out.println("languages: " + languages);
        System.out.println("downloads: " + downloads);

        System.out.println("=====================================");
    }
}

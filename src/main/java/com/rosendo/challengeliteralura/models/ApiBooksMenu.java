package com.rosendo.challengeliteralura.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rosendo.challengeliteralura.services.ApiBooksServices;

import java.util.Scanner;

public class ApiBooksMenu {

    private Integer exitVariable = -1;
    private final Scanner reading = new Scanner(System.in);

    private final String mainText =  """
                            -----------------------------------------------
                            Choose your desired option
                            -----------------------------------------------
                            
                            1 - Search for book by title;
                            2 - List registered books;
                            3 - List registered authors;
                            4 - List living authors in a given year;
                            5 - List books in a given language;
                            0 - quit
                            
                            """;

    public void runApp() throws JsonProcessingException {
        ApiBooksServices services = new ApiBooksServices();

        while (exitVariable != 0) {
            System.out.println(mainText);

            switch (reading.nextLine()){
                case "1":
                    services.searchBookByTitle();
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

}

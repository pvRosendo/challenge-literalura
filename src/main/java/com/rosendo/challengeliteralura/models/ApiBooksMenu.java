package com.rosendo.challengeliteralura.models;

import java.util.Scanner;

public class ApiBooksMenu {

    private Integer exitVariable = -1;
    private Scanner leitura = new Scanner(System.in);

    private final String mainText =  """
                            -----------------------------------------------
                            Escola sua opção desejada
                            -----------------------------------------------
                            
                            1 - buscar livro pelo titulo
                            2 - listar livros registrados
                            3 - listar autores registrados
                            4 - listar autores vivos em um determinado ano
                            5 - listar livros em determinado idioma
                            0 - quit
                            
                            """;

    public void showMainText(){
        while (exitVariable != 0) {
            System.out.println(mainText);

            switch (leitura.nextLine()){
                case "1":
                    System.out.println("option 1");
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

                default:
                    System.out.println("Invalid option!");
                break;
            }
        }
    }

    public void runApp(){
        showMainText();
    }

}

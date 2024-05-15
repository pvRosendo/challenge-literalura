package com.rosendo.challengeliteralura.models;

public class ApiBooksMenu {

    private Integer exitVariable = -1;

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
        }
    }

}

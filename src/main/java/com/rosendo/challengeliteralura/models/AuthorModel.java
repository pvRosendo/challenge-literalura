package com.rosendo.challengeliteralura.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tb_authors")
public class AuthorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String birthYear;
    private String deathYear;

    @OneToMany(mappedBy = "author")
    private List<BooksModel> books;

    public AuthorModel() {}

    public AuthorModel(String name, String birthYear, String deathYear, List<BooksModel> books) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.books = books;
    }


    @Override
    public String toString() {
        return "AuthorModel{" +
                "name='" + name + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", deathYear='" + deathYear + '\'' +
                ", books=" + books +
                '}';
    }
}

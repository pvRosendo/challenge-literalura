package com.rosendo.challengeliteralura.models;

import jakarta.persistence.*;

@Entity
@Table(name="tb_books")
public class BooksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private AuthorModel author;
    private String language;
    private Long downloads;

    public BooksModel(String title, AuthorModel author, String language, Long downloads) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.downloads = downloads;
    }

    public BooksModel() {}


    @Override
    public String toString() {
        return "BooksModel{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", language='" + language + '\'' +
                ", downloads=" + downloads +
                '}';
    }

}

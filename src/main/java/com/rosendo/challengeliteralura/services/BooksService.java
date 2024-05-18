package com.rosendo.challengeliteralura.services;

import com.rosendo.challengeliteralura.models.AuthorModel;
import com.rosendo.challengeliteralura.models.BooksModel;
import com.rosendo.challengeliteralura.repository.AuthorRepository;
import com.rosendo.challengeliteralura.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    public List<BooksModel> getAllBooks(){
        return booksRepository.findAll();
    }

    public List<BooksModel> getBooksByTitle(String title){
        var listOfBooks = new ArrayList<BooksModel>();
        return listOfBooks;
    }

}

package com.rosendo.challengeliteralura.repository;

import com.rosendo.challengeliteralura.models.BooksModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<BooksModel, Long> {

    List<BooksModel> findBooksByLanguage(String language);
}

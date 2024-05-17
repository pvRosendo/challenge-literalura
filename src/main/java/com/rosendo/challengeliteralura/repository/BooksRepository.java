package com.rosendo.challengeliteralura.repository;

import com.rosendo.challengeliteralura.models.BooksModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BooksModel, Long> {}

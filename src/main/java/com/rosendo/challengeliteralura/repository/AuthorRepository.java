package com.rosendo.challengeliteralura.repository;

import com.rosendo.challengeliteralura.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {}

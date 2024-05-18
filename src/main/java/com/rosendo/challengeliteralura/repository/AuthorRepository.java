package com.rosendo.challengeliteralura.repository;

import com.rosendo.challengeliteralura.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {}

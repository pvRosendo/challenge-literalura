package com.rosendo.challengeliteralura.repository;

import com.rosendo.challengeliteralura.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {

    List<AuthorModel> findByDeathYearLessThan(String deathYear);
}

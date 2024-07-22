package com.example.movie_checkr.repository;

import com.example.movie_checkr.model.ShowType;
import com.example.movie_checkr.model.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ShowsRepository extends JpaRepository<Shows, Long> {
    List<Shows> findByTitle(String title);
    List<Shows> findByGenre(String genre);
    List<Shows> findByCountry(String country);
    List<Shows> findByShowType(ShowType showType);

}

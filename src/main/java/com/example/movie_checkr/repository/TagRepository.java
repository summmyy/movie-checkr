package com.example.movie_checkr.repository;

import com.example.movie_checkr.model.Shows;
import com.example.movie_checkr.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tags, Shows> {
    List<Tags> findByShow(Shows show);
}

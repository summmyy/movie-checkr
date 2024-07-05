package com.example.movie_checkr.service;

import com.example.movie_checkr.model.ShowType;
import com.example.movie_checkr.model.Shows;
import com.example.movie_checkr.repository.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShowsService {

    private final ShowsRepository showsRepository;

    @Autowired
    public ShowsService(ShowsRepository showsRepository) {
        this.showsRepository = showsRepository;
    }

    public List<Shows> getAllShows() {
        return showsRepository.findAll();
    }

    public List<Shows> getShowsByTitle(String title) {
        return showsRepository.findByTitle(title);
    }

    public List<Shows> getShowsByGenre(String genre) {
        return showsRepository.findByGenre(genre);
    }

    public List<Shows> getShowsByCountry(String country) {
        return showsRepository.findByCountry(country);
    }

    public List<Shows> getShowsByShowType(ShowType showType){
        return showsRepository.findByShowType(showType);
    }

    public Shows createShow(Shows showDetails) {
        return showsRepository.save(showDetails);
    }

}

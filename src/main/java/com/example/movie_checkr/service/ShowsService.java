package com.example.movie_checkr.service;

import com.example.movie_checkr.model.ShowType;
import com.example.movie_checkr.model.Shows;
import com.example.movie_checkr.model.Tags;
import com.example.movie_checkr.repository.ShowsRepository;
import com.example.movie_checkr.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShowsService {

    private final ShowsRepository showsRepository;
    private final TagsService tagsService;

    @Autowired
    public ShowsService(ShowsRepository showsRepository, TagsService tagsService) {
        this.showsRepository = showsRepository;
        this.tagsService = tagsService;
    }

    public List<Shows> getAllShows() {
        return showsRepository.findAll();
    }

    public Set<String> getAllGenres(){
        List<Shows> allShows = showsRepository.findAll();
        Set<String> allGenres = new HashSet<>();

        for (Shows show : allShows) {
            allGenres.add(show.getGenre());
        }

        return allGenres;
    }

    public Set<String> getAllCountries(){
        List<Shows> allShows = showsRepository.findAll();
        Set<String> allCountries = new HashSet<>();

        for (Shows show : allShows) {
            allCountries.add(show.getCountry());
        }

        return allCountries;
    }

    public List<Tags> getShowsByTitle(String title) {
        Shows show =  showsRepository.findByTitle(title);
        List<Tags> similarShows = tagsService.getSimilarTags(show);
        return similarShows;
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

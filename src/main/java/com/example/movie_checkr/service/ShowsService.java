package com.example.movie_checkr.service;

import com.example.movie_checkr.model.ShowType;
import com.example.movie_checkr.model.Shows;
import com.example.movie_checkr.repository.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        /*

        List<Shows> similarShows;
        List<Shows> shows = showsService.getShowsByTitle(title);


        if (shows > 0){
           for i=0; i<len(shows.tags); i++{
                for j=0; j<len(show.tags); j++{
                    if (show.tags[j] == shows.tags[i]){
                        similarShows.append(show)
                    }
                }
           }

           shows.append(similarShows)

           return ResponseEntity.ok(shows)
           }
           else{
            return ResponseEntity.notfound()
           }


         */
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

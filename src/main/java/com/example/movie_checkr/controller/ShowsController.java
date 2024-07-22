package com.example.movie_checkr.controller;

import com.example.movie_checkr.model.ShowType;
import com.example.movie_checkr.model.Shows;
import com.example.movie_checkr.service.AuthenticationService;
import com.example.movie_checkr.service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowsController {

    private final ShowsService showsService;

    @Autowired
    public ShowsController(ShowsService showsService) {
        this.showsService = showsService;
    }

    @GetMapping("/test")
    public String getString() {
        return "This is the list of shows we have now";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Shows>> getAllShows() {
        List<Shows> shows = showsService.getAllShows();
        return ResponseEntity.ok(shows);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Shows>> getShowsByTitle(@PathVariable String title) {
        List<Shows> shows = (List<Shows>) showsService.getShowsByTitle(title);
        return ResponseEntity.ok(shows);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Shows>> getShowsByGenre(@PathVariable String genre) {
        List<Shows> shows = showsService.getShowsByGenre(genre);
        return ResponseEntity.ok(shows);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Shows>> getShowsByCountry(@PathVariable String country) {
        List<Shows> shows = showsService.getShowsByCountry(country);
        return ResponseEntity.ok(shows);
    }

    @GetMapping("/showType/{showType}")
    public ResponseEntity<List<Shows>> getShowsByShowType(@PathVariable ShowType showType){
        List<Shows> shows = showsService.getShowsByShowType(showType);
        return ResponseEntity.ok(shows);
    }


    @PostMapping("/create-show")
    public ResponseEntity<Shows> createShow(@RequestBody Shows showDetails) {
        Shows createdShow = showsService.createShow(showDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShow);
    }

}

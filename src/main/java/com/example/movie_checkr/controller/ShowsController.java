package com.example.movie_checkr.controller;

import com.example.movie_checkr.model.ShowType;
import com.example.movie_checkr.model.Shows;
import com.example.movie_checkr.model.Tags;
import com.example.movie_checkr.repository.TagRepository;
import com.example.movie_checkr.service.AuthenticationService;
import com.example.movie_checkr.service.ShowsService;
import com.example.movie_checkr.service.TagsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/shows")
public class ShowsController {

    private final ShowsService showsService;
    private final TagsService tagsService;
    private final ObjectMapper objectMapper;

    @Autowired
    public ShowsController(ShowsService showsService, TagsService tagsService, ObjectMapper objectMapper) {
        this.showsService = showsService;
        this.tagsService = tagsService;
        this.objectMapper = objectMapper;
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
    public ResponseEntity<List<Tags>> getShowsByTitle(@PathVariable String title) {
        List<Tags> shows = showsService.getShowsByTitle(title);
        return ResponseEntity.ok(shows);
    }

    @GetMapping("/genre/all")
    public ResponseEntity<Set<String>> getAllGenres(){
        Set<String> genres = showsService.getAllGenres();
        return ResponseEntity.ok(genres);
    }


    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Shows>> getShowsByGenre(@PathVariable String genre) {
        List<Shows> shows = showsService.getShowsByGenre(genre);
        return ResponseEntity.ok(shows);
    }

    @GetMapping("/country/all")
    public ResponseEntity<Set<String>> getAllCountries(){
        Set<String> genres = showsService.getAllCountries();
        return ResponseEntity.ok(genres);
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
    public ResponseEntity<Shows> createShow(@RequestBody Map<String, Object> requestBody) {
        // Extract show details and tag details from the requestBody map
        Shows showDetails = new Shows();
        Tags tagDetails = new Tags();

        // Assuming structure: { "showDetails": { ... }, "tagDetails": { ... } }
        if (requestBody.containsKey("showDetails")) {
            showDetails = objectMapper.convertValue(requestBody.get("showDetails"), Shows.class);
        }
        if (requestBody.containsKey("tagDetails")) {
            tagDetails = objectMapper.convertValue(requestBody.get("tagDetails"), Tags.class);
        }

        // Call services to create show and tags
        Shows createdShow = showsService.createShow(showDetails);
        Tags createdShowTags = tagsService.createShowTags(tagDetails);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdShow);
    }

//    @PostMapping("/create-show-tags")
//    public ResponseEntity<Tags> createShowTags (@RequestBody Map<String, Object> requestBody){
//        Tags tagDetails = new Tags();
//
//        if (requestBody.containsKey("tagDetails")) {
//            tagDetails = objectMapper.convertValue(requestBody.get("tagDetails"), Tags.class);
//        }
//
//        Tags createdShowTags = tagsService.createShowTags(tagDetails);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdShowTags);
//    }


}

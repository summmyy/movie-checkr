package com.example.movie_checkr.controller;

import com.example.movie_checkr.model.Shows;
import com.example.movie_checkr.model.Tags;
import com.example.movie_checkr.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagsController {

    private final TagsService tagsService;

    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tags>> getAllTags(){
        List<Tags> tags = tagsService.getAllTags();
        return ResponseEntity.ok(tags);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Tags>> getTagsByTitle(@PathVariable Shows title){
        List<Tags> tags = tagsService.getSimilarTags(title);
        return ResponseEntity.ok(tags);
    }
}

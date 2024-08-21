package com.example.movie_checkr.service;

import com.example.movie_checkr.model.Shows;
import com.example.movie_checkr.model.Tags;
import com.example.movie_checkr.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TagsService {

    private Shows shows;

    private final TagRepository tagRepository;

    @Autowired
    public TagsService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tags> getAllTags(){
        return tagRepository.findAll();
    }

    public List<Tags> getSimilarTags(Shows show) {
        List<Tags> showTags = tagRepository.findByShow(show);
        Set<String> allTagsSet = new HashSet<>();

        // Populate the allTagsSet with all the tags
        for (Tags tag : showTags) {
            allTagsSet.add(tag.getTag_1());
            allTagsSet.add(tag.getTag_2());
            allTagsSet.add(tag.getTag_3());
            allTagsSet.add(tag.getTag_4());
            allTagsSet.add(tag.getTag_5());
        }

        List<Tags> allShows = tagRepository.findAll();
        List<Tags> similarTags = new ArrayList<>();

        // Check for matching tags
        for (Tags tag : allShows) {
            if (allTagsSet.contains(tag.getTag_1()) ||
                    allTagsSet.contains(tag.getTag_2()) ||
                    allTagsSet.contains(tag.getTag_3()) ||
                    allTagsSet.contains(tag.getTag_4()) ||
                    allTagsSet.contains(tag.getTag_5())) {
                similarTags.add(tag);
            }
        }

        return similarTags;
    }

    public Tags createShowTags(Tags tagDetails) {
        return tagRepository.save(tagDetails);
    }
}

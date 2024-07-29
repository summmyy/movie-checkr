package com.example.movie_checkr.service;

import com.example.movie_checkr.model.Shows;
import com.example.movie_checkr.model.Tags;
import com.example.movie_checkr.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Tags> getSimilarTags(String show){
        List<Tags> showTags = tagRepository.findByShow(show);
        List<Tags> allShows = tagRepository.findAll();

        for(int i=0; i <= showTags.size(); i++ ){
            for (int j=0; j <= allShows.size(); j++){
                if(showTags.get(i).getTag_1() == allShows.get(j).getTag_1()){
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_1() == allShows.get(j).getTag_2()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_1() == allShows.get(j).getTag_3()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_1() == allShows.get(j).getTag_4()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_1() == allShows.get(j).getTag_5()) {
                    showTags.add(allShows.get(j));
                }
                // Second Tag search
                else if(showTags.get(i).getTag_2() == allShows.get(j).getTag_1()){
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_2() == allShows.get(j).getTag_2()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_2() == allShows.get(j).getTag_3()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_2() == allShows.get(j).getTag_4()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_2() == allShows.get(j).getTag_5()) {
                    showTags.add(allShows.get(j));
                }

                // Third tag search
                else if(showTags.get(i).getTag_3() == allShows.get(j).getTag_1()){
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_3() == allShows.get(j).getTag_2()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_3() == allShows.get(j).getTag_3()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_3() == allShows.get(j).getTag_4()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_3() == allShows.get(j).getTag_5()) {
                    showTags.add(allShows.get(j));
                }

                // Fourth Tag Search
                else if(showTags.get(i).getTag_4() == allShows.get(j).getTag_1()){
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_4() == allShows.get(j).getTag_2()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_4() == allShows.get(j).getTag_3()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_4() == allShows.get(j).getTag_4()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_4() == allShows.get(j).getTag_5()) {
                    showTags.add(allShows.get(j));
                }

                // Fifth Tag search
                else if(showTags.get(i).getTag_5() == allShows.get(j).getTag_1()){
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_5() == allShows.get(j).getTag_2()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_5() == allShows.get(j).getTag_3()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_5() == allShows.get(j).getTag_4()) {
                    showTags.add(allShows.get(j));
                }
                else if (showTags.get(i).getTag_5() == allShows.get(j).getTag_5()) {
                    showTags.add(allShows.get(j));
                }

            }
        }

        return showTags;
    }
}

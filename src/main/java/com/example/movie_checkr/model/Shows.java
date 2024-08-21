package com.example.movie_checkr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Shows")
//@JsonIgnoreProperties(ignoreUnknown = true) // for ignoring unknown json fields when making post requests
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "show_type")
    private ShowType showType;

    @Column(name = "genre")
    private String genre;

    @Column(name = "country")
    private String country;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "duration")
    private Integer duration;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "release_date")
    private Date releaseDate;


    @Column(name = "show_poster_url", length = 2048)
    private String showPosterUrl;

//    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Tags tags = new Tags();

    // Default constructor required by JPA
    public Shows() {

    }


    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ShowType getShowType() {
        return showType;
    }

    public void setShowType(ShowType showType) {
        this.showType = showType;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getShowPosterUrl() {
        return showPosterUrl;
    }

    public void setShowPosterUrl(String showPosterUrl) {
        this.showPosterUrl = showPosterUrl;
    }

}

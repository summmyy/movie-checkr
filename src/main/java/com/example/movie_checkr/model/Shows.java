package com.example.movie_checkr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Shows")
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
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

//    @Lob
//    @Column(name = "show_poster", length = 2048)
//    private String showPoster;

    // Temporary field to hold the URL, not persisted
    @Column(name = "show_poster_url", length = 2048)
    private String showPosterUrl;

    // Default constructor required by JPA
    public Shows() {

    }

    // Parameterized constructor
    public Shows(Long id, String title, ShowType showType, String genre, String country, String description, Integer duration, Date releaseDate, String showPosterUrl) {
        this.id = id;
        this.title = title;
        this.showType = showType;
        this.genre = genre;
        this.country = country;
        this.description = description;
        this.duration = duration;
        this.releaseDate = releaseDate;
//        this.showPoster = showPoster;
        this.showPosterUrl = showPosterUrl;
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

//    public byte[] getShowPoster() {
//        return showPoster;
//    }

//    public void setShowPoster(byte[] showPoster) {
//        this.showPoster = showPoster;
//    }

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

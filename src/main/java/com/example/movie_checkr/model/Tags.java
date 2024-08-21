package com.example.movie_checkr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tags")
//@JsonIgnoreProperties(ignoreUnknown = true) // for ignoring unknown json fields when making post requests
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "show_title", referencedColumnName = "title")
    private Shows show;

    @Column(name = "tag_1")
    private String tag_1;

    @Column(name = "tag_2")
    private String tag_2;

    @Column(name = "tag_3")
    private String tag_3;

    @Column(name = "tag_4")
    private String tag_4;

    @Column(name = "tag_5")
    private String tag_5;

    public Tags() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shows getShow() {
        return show;
    }

    public void setShow(Shows show) {
        this.show = show;
    }

    public String getTag_1() {
        return tag_1;
    }

    public void setTag_1(String tag_1) {
        this.tag_1 = tag_1;
    }

    public String getTag_2() {
        return tag_2;
    }

    public void setTag_2(String tag_2) {
        this.tag_2 = tag_2;
    }

    public String getTag_3() {
        return tag_3;
    }

    public void setTag_3(String tag_3) {
        this.tag_3 = tag_3;
    }

    public String getTag_4() {
        return tag_4;
    }

    public void setTag_4(String tag_4) {
        this.tag_4 = tag_4;
    }

    public String getTag_5() {
        return tag_5;
    }

    public void setTag_5(String tag_5) {
        this.tag_5 = tag_5;
    }
}

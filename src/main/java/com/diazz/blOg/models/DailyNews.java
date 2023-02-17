package com.diazz.blOg.models;

import jakarta.persistence.*;
@Entity
@Table(name = "dailynews")
public class DailyNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "anons")
    private String anons;

    @Column(name = "full_text")
    private String full_text;

    @Column(name = "views")
    private int views;

    public DailyNews(String title, String anons, String full_text, int views) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
        this.views = views;
    }

    public DailyNews() {

    }

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

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public DailyNews(String title, String anons, String full_text) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
    }

}

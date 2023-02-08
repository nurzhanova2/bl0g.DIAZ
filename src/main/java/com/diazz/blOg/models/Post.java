package com.diazz.blOg.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "anons")
    private String anons;

    @Column(name = "full_text")
    private String  full_text;

    @Column(name = "views")
    private int views;
}
package com.diazz.blOg.controllers;
import com.diazz.blOg.models.Post;
import com.diazz.blOg.repo.PostRepository;
import com.diazz.blOg.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;
@Controller
public class MainController {
    @Autowired
    private PostRepository PostRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main page");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About us page");
        return "about";
    }
}
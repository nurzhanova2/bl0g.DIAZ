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
public class AddController {
    @Autowired
    private PostRepository PostRepository;
    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text) {
        Post post = new Post(title, anons, full_text);
        PostRepository.save(post);
        return "redirect:/blog";
    }
}
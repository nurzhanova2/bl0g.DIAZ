package com.diazz.blOg.controllers;

import com.diazz.blOg.models.Post;
import com.diazz.blOg.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping(path = "/blog")
public class BlogController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public String blogMain(Model model){

        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }
    @PostMapping("/find")
    public String blogFindByTitle(@RequestParam String title, Model model){
        Iterable<Post> posts = postRepository.findPostsByTitle(title);
        model.addAttribute("foundPosts", posts);
        return "blog-found";
    }

}

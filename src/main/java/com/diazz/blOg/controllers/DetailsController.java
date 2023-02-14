package com.diazz.blOg.controllers;

import com.diazz.blOg.models.Post;
import com.diazz.blOg.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class DetailsController {
    @Autowired
    private PostRepository PostRepository;

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!PostRepository.existsById(id)) {
            return "redirect:/blog";
        }

        Optional<Post> post = PostRepository.findById(id);
        post.ifPresent(p -> model.addAttribute("post", p));
        return "blog-details";

    }
}
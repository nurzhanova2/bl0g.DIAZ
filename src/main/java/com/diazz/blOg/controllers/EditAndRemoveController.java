package com.diazz.blOg.controllers;

import com.diazz.blOg.models.Post;
import com.diazz.blOg.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@Controller
public class EditAndRemoveController {
    @Autowired
    private PostRepository PostRepository;

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = PostRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        PostRepository.save(post);
        return "redirect:/blog";
    }
    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id,Model model) {
        Post post = PostRepository.findById(id).orElseThrow();
        PostRepository.delete(post);
        return "redirect:/blog";
    }
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!PostRepository.existsById(id)) {
            return "redirect:/blog";
        }

        Optional<Post> post = PostRepository.findById(id);
        post.ifPresent(p -> model.addAttribute("post", p));
        return "blog-edit";

    }
}

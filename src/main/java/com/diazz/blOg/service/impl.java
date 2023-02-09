package com.diazz.blOg.service;

import com.diazz.blOg.models.Post;
import com.diazz.blOg.repo.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class impl {


    private PostRepository postRepository;

    public impl(PostRepository postRepository) {
        super();
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
}
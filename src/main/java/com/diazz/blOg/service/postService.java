package com.diazz.blOg.service;

import com.diazz.blOg.models.Post;
import com.diazz.blOg.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class postService {

    @Autowired
    private PostRepository postRepository;

    public postService(PostRepository postRepository) {
        super();
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
}
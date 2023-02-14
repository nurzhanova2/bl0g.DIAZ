package com.diazz.blOg.repo;

import com.diazz.blOg.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Iterable<Post> findPostsByTitle(String title);
}

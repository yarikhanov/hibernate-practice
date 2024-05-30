package com.example.hibernate_practice.controller;

import com.example.hibernate_practice.model.Post;
import com.example.hibernate_practice.service.PostService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Controller
public class PostController {

    PostService postService;

    public Post getById(Long id) {
        return postService.getById(id);
    }

    public List<Post> getAll() {
        return postService.getAll();
    }

    public Post save(Post post) {
        return postService.save(post);
    }

    public Post update(Post post) {
        return postService.save(post);
    }

    public void delete(Long id) {
        postService.delete(id);
    }
}

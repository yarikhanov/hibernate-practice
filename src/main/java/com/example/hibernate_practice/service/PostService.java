package com.example.hibernate_practice.service;

import com.example.hibernate_practice.model.Post;
import com.example.hibernate_practice.repository.PostRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostService {

    PostRepo postRepo;

    public Post getById(Long id) {
        return postRepo.findById(id).orElse(null);
    }

    public List<Post> getAll() {
        return postRepo.findAll();
    }

    public Post save(Post post) {
        return postRepo.save(post);
    }

    public Post update(Post post) {
        return postRepo.save(post);
    }

    public void delete(Long id) {
        postRepo.deleteById(id);
    }
}

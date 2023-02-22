package org.example.controller;

import org.example.model.Post;
import org.example.service.PostService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService service;
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public ConcurrentHashMap<Long, Post> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Optional<Post> getById(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        return service.save(post);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable long id) {
        service.removeById(id);

    }

    public Long parsId (String path) {
        return Long.parseLong(path.substring(path.lastIndexOf("/") + 1));
    }
}

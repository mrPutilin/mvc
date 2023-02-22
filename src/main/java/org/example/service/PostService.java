package org.example.service;

import org.example.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.example.model.Post;
import org.example.repository.PostRepository;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public ConcurrentHashMap<Long, Post> all() {
        return repository.all();
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(repository.getById(id)).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}

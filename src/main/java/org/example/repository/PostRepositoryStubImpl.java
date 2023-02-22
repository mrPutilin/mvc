package org.example.repository;

import org.springframework.stereotype.Repository;
import org.example.model.Post;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// Stub
@Repository
public class PostRepositoryStubImpl implements PostRepository {
    protected ConcurrentHashMap<Long, Post> postStorage = new ConcurrentHashMap<>();
    private final AtomicLong count = new AtomicLong(0);

    public ConcurrentHashMap<Long, Post> all() {
        return postStorage;
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(postStorage.get(id));
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setId(count.incrementAndGet());
            postStorage.put(post.getId(), post);
        }
        postStorage.put(post.getId(), post);

        return post;
    }

    public void removeById(long id) {
        postStorage.remove(id);

    }
}

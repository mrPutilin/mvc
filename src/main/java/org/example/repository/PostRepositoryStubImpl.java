package org.example.repository;

import org.example.exception.NotFoundException;
import org.springframework.stereotype.Repository;
import org.example.model.Post;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

// Stub
@Repository
public class PostRepositoryStubImpl implements PostRepository {
    protected ConcurrentMap<Long, Post> postStorage = new ConcurrentHashMap<>();
    private final AtomicLong count = new AtomicLong(0);

    public ConcurrentMap<Long, Post> all() {
        return postStorage.entrySet().stream()
                .filter(e -> e.getValue().isRemoved())
                .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(postStorage.get(id));
    }

    public Post save(Post post) {
        if (post.getId() == 0 && post.isRemoved()) {
            post.setId(count.incrementAndGet());
            postStorage.put(post.getId(), post);
        }
        postStorage.put(post.getId(), post);

        return post;
    }

    public void removeById(long id) {
        if (!postStorage.containsKey(id) || !postStorage.get(id).isRemoved())
            throw new NotFoundException();
        postStorage.get(id).setRemoved(true);
    }
}

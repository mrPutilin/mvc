package org.example.model;

public class Post {
    public long id;
    public String content;
    public boolean removed;

    public Post() {
    }
    public Post(long id, String content, boolean removed) {
        this.id = id;
        this.content = content;
        this.removed = removed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRemoved() {
        return !removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

}

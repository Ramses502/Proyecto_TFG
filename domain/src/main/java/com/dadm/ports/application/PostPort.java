package com.dadm.ports.application;

import com.dadm.model.Post;

import java.util.List;

public interface PostPort {

    List<Post> getPosts();
    Post getPost(Long id);
    void uploadPost(Post post);
    void updatePost(Post post);
    void deletePost(Post post);
    void deleteById(Long id);
}

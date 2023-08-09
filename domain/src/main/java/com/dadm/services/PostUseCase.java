package com.dadm.services;

import com.dadm.model.Post;
import com.dadm.ports.application.PostPort;
import com.dadm.ports.infrastructure.PostDbPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostUseCase implements PostPort {

    private final PostDbPort postDbPort;

    @Override
    public List<Post> getPosts() {
        return postDbPort.getPosts();
    }

    @Override
    public Post getPost(Long id) {
        return postDbPort.getPost(id);
    }

    @Override
    public void uploadPost(Post post) {
        postDbPort.uploadPost(post);
    }

    @Override
    public void updatePost(Post post) {
        postDbPort.updatePost(post);
    }

    @Override
    public void deletePost(Post post) {
        postDbPort.deletePost(post);
    }

    @Override
    public void deleteById(Long id) {
        postDbPort.deleteById(id);
    }
}

package com.dadm.adapter;

import com.dadm.mapper.PostDbMapper;
import com.dadm.model.Post;
import com.dadm.ports.infrastructure.PostDbPort;
import com.dadm.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PostDbAdapter implements PostDbPort {

    private final PostDbMapper mapper = PostDbMapper.INSTANCE;
    private final PostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        return null;
    }

    @Override
    public Post getPost(Long id) {
        return null;
    }

    @Override
    public void uploadPost(Post post) {

    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void deletePost(Post post) {

    }

    @Override
    public void deleteById(Long id) {

    }
}

package com.dadm.adapter;

import com.dadm.mapper.PostDbMapper;
import com.dadm.model.Post;
import com.dadm.ports.infrastructure.PostDbPort;
import com.dadm.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PostDbAdapter implements PostDbPort {

    private final PostDbMapper mapper = PostDbMapper.INSTANCE;
    private final PostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll().stream().map(mapper::aDominio).collect(Collectors.toList());
    }

    @Override
    public Post getPost(Long id) {
        return mapper.aDominio(postRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe este post")));
    }

    @Override
    public void uploadPost(Post post) {
        postRepository.save(mapper.aDb(post));
    }

    @Override
    public void updatePost(Post post) {
        postRepository.save(mapper.aDb(post));
    }

    @Override
    public void deletePost(Post post) {
        postRepository.delete(mapper.aDb(post));
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}

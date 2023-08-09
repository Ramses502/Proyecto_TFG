package com.dadm.adapter;

import com.dadm.mapper.PostMapper;
import com.dadm.model.PostDto;
import com.dadm.ports.application.PostPort;
import com.dadm.ports.infrastructure.PostDbPort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {

    private final PostMapper mapper = PostMapper.INSTANCE;
    private final PostPort postPort;

    @GetMapping("/all")
    public List<PostDto> getAll() {
        return postPort.getPosts().stream()
                .map(mapper::aDto)
                .collect(Collectors.toList());
    }

    @GetMapping
    public PostDto getPost(Long id) {
        return mapper.aDto(postPort.getPost(id));
    }

    @PostMapping
    public void uploadPost(PostDto postDto) {
        postPort.uploadPost(mapper.aDominio(postDto));
    }

    @PutMapping
    public void updatePost(PostDto postDto) {
        postPort.updatePost(mapper.aDominio(postDto));
    }

    @DeleteMapping
    public void deletePost(PostDto postDto) {
        postPort.deletePost(mapper.aDominio(postDto));
    }

    @DeleteMapping
    public void deletePostById(Long id) {
        postPort.deleteById(id);
    }
}

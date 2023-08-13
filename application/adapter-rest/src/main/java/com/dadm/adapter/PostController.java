package com.dadm.adapter;

import com.dadm.mapper.PostMapper;
import com.dadm.model.PostDto;
import com.dadm.ports.application.PostPort;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<PostDto> getAll() {
        return postPort.getPosts().stream()
                .map(mapper::aDto)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public PostDto getPost(Long id) {
        return mapper.aDto(postPort.getPost(id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public void uploadPost(@RequestBody PostDto postDto) {
        postPort.uploadPost(mapper.aDominio(postDto));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public void updatePost(PostDto postDto) {
        postPort.updatePost(mapper.aDominio(postDto));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping
    public void deletePost(PostDto postDto) {
        postPort.deletePost(mapper.aDominio(postDto));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable Long id) {
        postPort.deleteById(id);
    }
}

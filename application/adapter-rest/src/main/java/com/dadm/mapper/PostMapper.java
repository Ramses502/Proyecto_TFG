package com.dadm.mapper;

import com.dadm.model.Post;
import com.dadm.model.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostDto aDto(Post post);

    Post aDominio(PostDto postDto);
}

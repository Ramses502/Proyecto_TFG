package com.dadm.mapper;

import com.dadm.model.Post;
import com.dadm.model.PostMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostDbMapper {

    PostDbMapper INSTANCE = Mappers.getMapper(PostDbMapper.class);

    @Mapping(source = "user", target = "userMO")
    PostMO aDb(Post post);

    @Mapping(source = "userMO", target = "user")
    Post aDominio(PostMO postMO);
}

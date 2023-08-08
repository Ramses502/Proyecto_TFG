package com.dadm.mapper;

import com.dadm.model.Post;
import com.dadm.model.PostMO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostDbMapper {

    PostDbMapper INSTANCE = Mappers.getMapper(PostDbMapper.class);

    PostMO aDb(Post post);

    Post aDominio(PostMO postMO);
}

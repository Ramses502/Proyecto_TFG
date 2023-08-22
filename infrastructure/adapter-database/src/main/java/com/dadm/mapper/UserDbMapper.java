package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.UserMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDbMapper {

    UserDbMapper INSTANCE = Mappers.getMapper(UserDbMapper.class);

    @Mapping(source = "eventsMO", target = "events")
    User aDominio(UserMO userMO);

    @Mapping(source = "events", target = "eventsMO")
    UserMO aDb(User user);

}

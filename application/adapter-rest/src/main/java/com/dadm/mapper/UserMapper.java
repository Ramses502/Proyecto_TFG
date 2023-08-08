package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto aDto(User user);

    User aDominio(UserDto userDTO);
}

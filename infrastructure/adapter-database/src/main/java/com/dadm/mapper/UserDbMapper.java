package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.UserMO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDbMapper {

    UserDbMapper INSTANCE = Mappers.getMapper(UserDbMapper.class);

    User aDominio(UserMO userMO);

    UserMO aDb(User user);

}

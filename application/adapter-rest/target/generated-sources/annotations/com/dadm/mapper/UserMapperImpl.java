package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.User.UserBuilder;
import com.dadm.model.UserDto;
import com.dadm.model.UserDto.UserDtoBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T18:15:36+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto aDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.name( user.getName() );
        userDto.password( user.getPassword() );
        userDto.elo( user.getElo() );
        userDto.avatar( user.getAvatar() );

        return userDto.build();
    }

    @Override
    public User aDominio(UserDto userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.name( userDTO.getName() );
        user.password( userDTO.getPassword() );
        user.elo( userDTO.getElo() );
        user.avatar( userDTO.getAvatar() );

        return user.build();
    }
}

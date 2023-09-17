package com.dadm.mapper;

import com.dadm.model.Post;
import com.dadm.model.Post.PostBuilder;
import com.dadm.model.PostDto;
import com.dadm.model.PostDto.PostDtoBuilder;
import com.dadm.model.User;
import com.dadm.model.User.UserBuilder;
import com.dadm.model.UserDto;
import com.dadm.model.UserDto.UserDtoBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T13:39:22+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDto aDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDtoBuilder postDto = PostDto.builder();

        postDto.id( post.getId() );
        postDto.text( post.getText() );
        postDto.date( post.getDate() );
        postDto.picture( post.getPicture() );
        postDto.user( userToUserDto( post.getUser() ) );

        return postDto.build();
    }

    @Override
    public Post aDominio(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        PostBuilder post = Post.builder();

        post.id( postDto.getId() );
        post.text( postDto.getText() );
        post.date( postDto.getDate() );
        post.picture( postDto.getPicture() );
        post.user( userDtoToUser( postDto.getUser() ) );

        return post.build();
    }

    protected UserDto userToUserDto(User user) {
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

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.name( userDto.getName() );
        user.password( userDto.getPassword() );
        user.elo( userDto.getElo() );
        user.avatar( userDto.getAvatar() );

        return user.build();
    }
}

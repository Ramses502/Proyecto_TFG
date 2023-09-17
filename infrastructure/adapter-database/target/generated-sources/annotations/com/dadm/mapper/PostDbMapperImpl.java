package com.dadm.mapper;

import com.dadm.model.Post;
import com.dadm.model.Post.PostBuilder;
import com.dadm.model.PostMO;
import com.dadm.model.User;
import com.dadm.model.User.UserBuilder;
import com.dadm.model.UserMO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T20:40:20+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class PostDbMapperImpl implements PostDbMapper {

    @Override
    public PostMO aDb(Post post) {
        if ( post == null ) {
            return null;
        }

        PostMO postMO = new PostMO();

        postMO.setUserMO( userToUserMO( post.getUser() ) );
        postMO.setId( post.getId() );
        postMO.setText( post.getText() );
        postMO.setDate( post.getDate() );
        postMO.setPicture( post.getPicture() );

        return postMO;
    }

    @Override
    public Post aDominio(PostMO postMO) {
        if ( postMO == null ) {
            return null;
        }

        PostBuilder post = Post.builder();

        post.user( userMOToUser( postMO.getUserMO() ) );
        post.id( postMO.getId() );
        post.text( postMO.getText() );
        post.date( postMO.getDate() );
        post.picture( postMO.getPicture() );

        return post.build();
    }

    protected UserMO userToUserMO(User user) {
        if ( user == null ) {
            return null;
        }

        UserMO userMO = new UserMO();

        userMO.setName( user.getName() );
        userMO.setPassword( user.getPassword() );
        userMO.setElo( user.getElo() );
        userMO.setAvatar( user.getAvatar() );

        return userMO;
    }

    protected User userMOToUser(UserMO userMO) {
        if ( userMO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.name( userMO.getName() );
        user.password( userMO.getPassword() );
        user.elo( userMO.getElo() );
        user.avatar( userMO.getAvatar() );

        return user.build();
    }
}

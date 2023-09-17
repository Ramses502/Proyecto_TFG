package com.dadm.mapper;

import com.dadm.model.Event;
import com.dadm.model.Event.EventBuilder;
import com.dadm.model.EventDto;
import com.dadm.model.EventDto.EventDtoBuilder;
import com.dadm.model.User;
import com.dadm.model.User.UserBuilder;
import com.dadm.model.UserDto;
import com.dadm.model.UserDto.UserDtoBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T18:15:36+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class EventMapperImpl implements EventMapper {

    @Override
    public EventDto aDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDtoBuilder eventDto = EventDto.builder();

        eventDto.id( event.getId() );
        eventDto.name( event.getName() );
        eventDto.description( event.getDescription() );
        eventDto.address( event.getAddress() );
        eventDto.date( event.getDate() );
        eventDto.capacity( event.getCapacity() );
        eventDto.apuntado( event.getApuntado() );
        eventDto.users( userListToUserDtoList( event.getUsers() ) );

        return eventDto.build();
    }

    @Override
    public Event aDominio(EventDto eventDto) {
        if ( eventDto == null ) {
            return null;
        }

        EventBuilder event = Event.builder();

        event.id( eventDto.getId() );
        event.name( eventDto.getName() );
        event.description( eventDto.getDescription() );
        event.address( eventDto.getAddress() );
        event.date( eventDto.getDate() );
        event.capacity( eventDto.getCapacity() );
        event.apuntado( eventDto.getApuntado() );
        event.users( userDtoListToUserList( eventDto.getUsers() ) );

        return event.build();
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

    protected List<UserDto> userListToUserDtoList(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<UserDto> list1 = new ArrayList<UserDto>( list.size() );
        for ( User user : list ) {
            list1.add( userToUserDto( user ) );
        }

        return list1;
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

    protected List<User> userDtoListToUserList(List<UserDto> list) {
        if ( list == null ) {
            return null;
        }

        List<User> list1 = new ArrayList<User>( list.size() );
        for ( UserDto userDto : list ) {
            list1.add( userDtoToUser( userDto ) );
        }

        return list1;
    }
}

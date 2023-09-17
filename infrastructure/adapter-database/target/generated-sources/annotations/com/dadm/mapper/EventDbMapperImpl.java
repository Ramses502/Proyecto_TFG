package com.dadm.mapper;

import com.dadm.model.Event;
import com.dadm.model.Event.EventBuilder;
import com.dadm.model.EventMO;
import com.dadm.model.EventUserMO;
import com.dadm.model.User;
import com.dadm.model.User.UserBuilder;
import com.dadm.model.UserMO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T18:06:33+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class EventDbMapperImpl implements EventDbMapper {

    @Override
    public Event aDominio(EventMO eventMO) {
        if ( eventMO == null ) {
            return null;
        }

        EventBuilder event = Event.builder();

        event.users( eventUserMOListToUserList( eventMO.getUsersMO() ) );
        event.id( eventMO.getId() );
        event.name( eventMO.getName() );
        event.description( eventMO.getDescription() );
        event.address( eventMO.getAddress() );
        event.date( eventMO.getDate() );
        event.capacity( eventMO.getCapacity() );

        return event.build();
    }

    @Override
    public EventMO aDb(Event event) {
        if ( event == null ) {
            return null;
        }

        EventMO eventMO = new EventMO();

        eventMO.setUsersMO( userListToEventUserMOList( event.getUsers() ) );
        eventMO.setId( event.getId() );
        eventMO.setName( event.getName() );
        eventMO.setDescription( event.getDescription() );
        eventMO.setAddress( event.getAddress() );
        eventMO.setDate( event.getDate() );
        eventMO.setCapacity( event.getCapacity() );

        return eventMO;
    }

    protected User eventUserMOToUser(EventUserMO eventUserMO) {
        if ( eventUserMO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        return user.build();
    }

    protected List<User> eventUserMOListToUserList(List<EventUserMO> list) {
        if ( list == null ) {
            return null;
        }

        List<User> list1 = new ArrayList<User>( list.size() );
        for ( EventUserMO eventUserMO : list ) {
            list1.add( eventUserMOToUser( eventUserMO ) );
        }

        return list1;
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

    protected EventUserMO userToEventUserMO(User user) {
        if ( user == null ) {
            return null;
        }

        EventUserMO eventUserMO = new EventUserMO();

        eventUserMO.setUser( userToUserMO( user ) );

        return eventUserMO;
    }

    protected List<EventUserMO> userListToEventUserMOList(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<EventUserMO> list1 = new ArrayList<EventUserMO>( list.size() );
        for ( User user : list ) {
            list1.add( userToEventUserMO( user ) );
        }

        return list1;
    }
}

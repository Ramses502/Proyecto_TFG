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
    date = "2023-09-17T13:39:20+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class UserDbMapperImpl implements UserDbMapper {

    @Override
    public User aDominio(UserMO userMO) {
        if ( userMO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.events( eventUserMOListToEventList( userMO.getEventsMO() ) );
        user.name( userMO.getName() );
        user.password( userMO.getPassword() );
        user.elo( userMO.getElo() );
        user.avatar( userMO.getAvatar() );

        return user.build();
    }

    @Override
    public UserMO aDb(User user) {
        if ( user == null ) {
            return null;
        }

        UserMO userMO = new UserMO();

        userMO.setEventsMO( eventListToEventUserMOList( user.getEvents() ) );
        userMO.setName( user.getName() );
        userMO.setPassword( user.getPassword() );
        userMO.setElo( user.getElo() );
        userMO.setAvatar( user.getAvatar() );

        return userMO;
    }

    protected Event eventUserMOToEvent(EventUserMO eventUserMO) {
        if ( eventUserMO == null ) {
            return null;
        }

        EventBuilder event = Event.builder();

        return event.build();
    }

    protected List<Event> eventUserMOListToEventList(List<EventUserMO> list) {
        if ( list == null ) {
            return null;
        }

        List<Event> list1 = new ArrayList<Event>( list.size() );
        for ( EventUserMO eventUserMO : list ) {
            list1.add( eventUserMOToEvent( eventUserMO ) );
        }

        return list1;
    }

    protected EventMO eventToEventMO(Event event) {
        if ( event == null ) {
            return null;
        }

        EventMO eventMO = new EventMO();

        eventMO.setId( event.getId() );
        eventMO.setName( event.getName() );
        eventMO.setDescription( event.getDescription() );
        eventMO.setAddress( event.getAddress() );
        eventMO.setDate( event.getDate() );
        eventMO.setCapacity( event.getCapacity() );

        return eventMO;
    }

    protected EventUserMO eventToEventUserMO(Event event) {
        if ( event == null ) {
            return null;
        }

        EventUserMO eventUserMO = new EventUserMO();

        eventUserMO.setEvent( eventToEventMO( event ) );

        return eventUserMO;
    }

    protected List<EventUserMO> eventListToEventUserMOList(List<Event> list) {
        if ( list == null ) {
            return null;
        }

        List<EventUserMO> list1 = new ArrayList<EventUserMO>( list.size() );
        for ( Event event : list ) {
            list1.add( eventToEventUserMO( event ) );
        }

        return list1;
    }
}

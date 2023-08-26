package com.dadm.ports.infrastructure;

import com.dadm.model.Event;

import java.util.List;

public interface EventDbPort {

    List<Event> getEvents();
    Event getEvent(Long id);
    void uploadEvent(Event event);
    void updateEvent(Event event);
    void deleteEvent(Event event);
    void deleteEventById(Long id);

    void insertUserToEvent(String userName, Long eventId);
    void deleteUserToEvent(String userName, Long eventId);

    Event getEventFromName(String eventName);

    List<Event> getAllEventsFromUser(String userName);
}

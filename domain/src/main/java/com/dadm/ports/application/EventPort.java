package com.dadm.ports.application;

import com.dadm.model.Event;

import java.util.List;

public interface EventPort {

    List<Event> getEvents();
    Event getEvent(Long id);
    void uploadEvent(Event event);

    void insertUserToEvent(String userName, Long eventId);
    void deleteUserToEvent(String userName, Long eventId);

    void updateEvent(Event event);
    void deleteEvent(Event event);
    void deleteEventById(Long id);
    List<Event> getEventsFromUser(String userName);
}

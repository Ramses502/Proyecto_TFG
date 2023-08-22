package com.dadm.services;

import com.dadm.model.Event;
import com.dadm.model.User;
import com.dadm.ports.application.EventPort;
import com.dadm.ports.infrastructure.EventDbPort;
import com.dadm.ports.infrastructure.UserDbPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class EventUseCase implements EventPort {

    private final EventDbPort eventDbPort;
    private final UserDbPort userDbPort;

    @Override
    public List<Event> getEvents() {
        return eventDbPort.getEvents();
    }

    @Override
    public Event getEvent(Long id) {
        return eventDbPort.getEvent(id);
    }

    @Override
    public void uploadEvent(Event event) {
        User user = userDbPort.get(event.getUsers().get(0).getName());
        user.getEvents().add(event);
        event.setUsers(List.of(user));
        eventDbPort.uploadEvent(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventDbPort.updateEvent(event);
    }

    @Override
    public void deleteEvent(Event event) {
        eventDbPort.deleteEvent(event);
    }

    @Override
    public void deleteEventById(Long id) {
        eventDbPort.deleteEventById(id);
    }

    @Override
    public List<Event> getEventsFromUser(String userName) {
        List<Event> events = eventDbPort.getEventsFromUser(userName);
        List<Event> eventsResult = new ArrayList<>();
        for (Event event : events) {
            for (User user : event.getUsers()) {
                if (Objects.equals(user.getName(), userName)) {
                    eventsResult.add(event);
                }
            }
        }
        return eventsResult;
    }
}

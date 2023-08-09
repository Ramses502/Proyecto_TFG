package com.dadm.services;

import com.dadm.model.Event;
import com.dadm.ports.application.EventPort;
import com.dadm.ports.infrastructure.EventDbPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventUseCase implements EventPort {

    private final EventDbPort eventDbPort;

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
}

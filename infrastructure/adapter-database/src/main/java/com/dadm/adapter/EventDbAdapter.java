package com.dadm.adapter;

import com.dadm.mapper.EventDbMapper;
import com.dadm.model.Event;
import com.dadm.ports.infrastructure.EventDbPort;
import com.dadm.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EventDbAdapter  implements EventDbPort {

    private final EventDbMapper mapper = EventDbMapper.INSTANCE;
    private final EventRepository eventRepository;

    @Override
    public List<Event> getEvents() {
        return null;
    }

    @Override
    public Event getEvent(Long id) {
        return null;
    }

    @Override
    public void uploadEvent(Event event) {

    }

    @Override
    public void updateEvent(Event event) {

    }

    @Override
    public void deleteEvent(Event event) {

    }

    @Override
    public void deleteEventById(Long id) {

    }
}

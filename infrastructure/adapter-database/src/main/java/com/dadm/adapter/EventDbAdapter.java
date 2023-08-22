package com.dadm.adapter;

import com.dadm.mapper.EventDbMapper;
import com.dadm.model.Event;
import com.dadm.ports.infrastructure.EventDbPort;
import com.dadm.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EventDbAdapter  implements EventDbPort {

    private final EventDbMapper mapper = EventDbMapper.INSTANCE;
    private final EventRepository eventRepository;

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll().stream().map(mapper::aDominio).collect(Collectors.toList());
    }

    @Override
    public Event getEvent(Long id) {
        return mapper.aDominio(eventRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe el evento")));
    }

    @Override
    @Transactional
    public void uploadEvent(Event event) {
        eventRepository.save(mapper.aDb(event));
    }

    @Override
    public void updateEvent(Event event) {
        eventRepository.save(mapper.aDb(event));
    }

    @Override
    public void deleteEvent(Event event) {
        eventRepository.delete(mapper.aDb(event));
    }

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getEventsFromUser(String userName) {
        return eventRepository.getEventsFromUser(userName).stream().map(mapper::aDominio).collect(Collectors.toList());
    }
}

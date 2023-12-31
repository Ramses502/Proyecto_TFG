package com.dadm.adapter;

import com.dadm.mapper.EventMapper;
import com.dadm.model.EventDto;
import com.dadm.ports.application.EventPort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {

    private final EventMapper mapper = EventMapper.INSTANCE;
    private final EventPort eventPort;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<EventDto> getAll() {
        return eventPort.getEvents()
                .stream().map(mapper::aDto)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public EventDto getEvent(@RequestParam Long id) {
        return mapper.aDto(eventPort.getEvent(id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public void uploadEvent(@RequestBody EventDto eventDto) {
        eventPort.uploadEvent(mapper.aDominio(eventDto));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public void updateEvent(@RequestBody EventDto eventDto) {
        eventPort.updateEvent(mapper.aDominio(eventDto));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping
    public void deleteEvent(@RequestBody EventDto eventDto) {
        eventPort.deleteEvent(mapper.aDominio(eventDto));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteEventById(@PathVariable Long id) {
        eventPort.deleteEventById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{userName}")
    public List<EventDto> getEventsFromUser(@PathVariable String userName) {
        return eventPort.getEventsFromUser(userName).stream().map(mapper::aDto).collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{userName}/{eventId}")
    public void insertUserToEvent(@PathVariable String userName, @PathVariable Long eventId) {
        eventPort.insertUserToEvent(userName, eventId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{userName}/{eventId}")
    public void deleteUserToEvent(@PathVariable String userName, @PathVariable Long eventId) {
        eventPort.deleteUserToEvent(userName, eventId);
    }
}

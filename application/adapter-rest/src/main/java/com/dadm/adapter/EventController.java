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
    public EventDto getEvent(Long id) {
        return mapper.aDto(eventPort.getEvent(id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public void uploadEvent(EventDto eventDto) {
        eventPort.uploadEvent(mapper.aDominio(eventDto));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public void updateEvent(EventDto eventDto) {
        eventPort.updateEvent(mapper.aDominio(eventDto));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping
    public void deleteEvent(EventDto eventDto) {
        eventPort.deleteEvent(mapper.aDominio(eventDto));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteEventById(@PathVariable Long id) {
        eventPort.deleteEventById(id);
    }
}

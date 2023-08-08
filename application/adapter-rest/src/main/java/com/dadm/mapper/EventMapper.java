package com.dadm.mapper;

import com.dadm.model.Event;
import com.dadm.model.EventDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventDto aDto(Event event);

    Event aDominio(EventDto eventDto);
}

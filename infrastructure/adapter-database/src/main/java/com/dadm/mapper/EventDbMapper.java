package com.dadm.mapper;

import com.dadm.model.Event;
import com.dadm.model.EventMO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventDbMapper {

    EventDbMapper INSTANCE = Mappers.getMapper(EventDbMapper.class);

    Event aDominio(EventMO eventMO);

    EventMO aDb(Event event);
}

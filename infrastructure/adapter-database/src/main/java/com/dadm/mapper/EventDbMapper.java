package com.dadm.mapper;

import com.dadm.model.Event;
import com.dadm.model.EventMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventDbMapper {

    EventDbMapper INSTANCE = Mappers.getMapper(EventDbMapper.class);

    @Mapping(source = "userMO", target = "user")
    Event aDominio(EventMO eventMO);

    @Mapping(source = "user", target = "userMO")
    EventMO aDb(Event event);
}

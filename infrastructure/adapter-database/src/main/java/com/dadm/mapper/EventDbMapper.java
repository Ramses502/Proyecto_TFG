package com.dadm.mapper;

import com.dadm.model.Event;
import com.dadm.model.EventMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventDbMapper {

    EventDbMapper INSTANCE = Mappers.getMapper(EventDbMapper.class);

    @Mapping(source = "usersMO", target = "users")
    Event aDominio(EventMO eventMO);

    @Mapping(source = "users", target = "usersMO")
    EventMO aDb(Event event);
}

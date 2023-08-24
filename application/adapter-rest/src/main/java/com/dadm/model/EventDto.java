package com.dadm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {

    private Long id;
    private String name;
    private String description;
    private String address;
    private LocalDate date;
    private Integer capacity;
    private Boolean apuntado;
    private List<UserDto> users;
}

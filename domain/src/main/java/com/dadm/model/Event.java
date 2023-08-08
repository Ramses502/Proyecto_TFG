package com.dadm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Event {

    private Long id;
    private String name;
    private String description;
    private String address;
    private LocalDate date;
    private Integer capacity;
}

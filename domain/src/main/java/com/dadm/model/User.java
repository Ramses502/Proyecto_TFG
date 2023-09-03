package com.dadm.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class User {

    private String name;
    private String password;
    private Integer elo;
    private String avatar;
    private List<Event> events;
}

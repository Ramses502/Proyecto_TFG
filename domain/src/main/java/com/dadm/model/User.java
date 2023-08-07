package com.dadm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class User {

    private String name;
    private String password;
    private Integer elo;
}

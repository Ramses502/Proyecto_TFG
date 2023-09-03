package com.dadm.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String name;

    private String password;

    private Integer elo;

    private String avatar;
}

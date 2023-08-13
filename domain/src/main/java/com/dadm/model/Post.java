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
public class Post {

    private Long id;
    private String text;
    private LocalDate date;
    private String picture;
    private User user;
}

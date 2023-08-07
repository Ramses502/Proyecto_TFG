package com.dadm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Post")
public class PostMO {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "text")
    private String text;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "picture")
    private String picture;
}

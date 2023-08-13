package com.dadm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Post")
public class PostMO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto hará que la ID sea autoincremental
    @Column(name = "id")
    private Long id;
    @Column(name = "text")
    private String text;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "picture")
    private String picture;
    @ManyToOne
    @JoinColumn(name = "user_name") // Asume que la columna de la clave foránea se llama "user_name"
    private UserMO userMO;
}

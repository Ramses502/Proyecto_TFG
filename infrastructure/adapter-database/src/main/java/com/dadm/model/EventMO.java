package com.dadm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Evento")
public class EventMO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto hará que la ID sea autoincremental
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "address")
    private String address;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "capacity")
    private Integer capacity;
    @OneToMany(mappedBy = "event")
    private List<EventUserMO> usersMO = new ArrayList<EventUserMO>();
}

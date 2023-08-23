package com.dadm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "EventUser")
@IdClass(EventUserMO.class)
public class EventUserMO implements Serializable {
    @Id
    @ManyToOne
    UserMO user;

    @Id
    @ManyToOne
    EventMO event;
}

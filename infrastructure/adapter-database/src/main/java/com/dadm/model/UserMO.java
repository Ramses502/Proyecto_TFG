package com.dadm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Users")
public class UserMO {

    @Id
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "elo")
    private Integer elo;
    @OneToMany(mappedBy = "userMO", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostMO> postsMO = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "user_event",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<EventMO> eventsMO = new ArrayList<>();
}

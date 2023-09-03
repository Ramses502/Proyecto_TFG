package com.dadm.model;

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
    @Column(name = "avatar")
    private String avatar;
    @OneToMany(mappedBy = "userMO", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostMO> postsMO = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<EventUserMO> eventsMO = new ArrayList<EventUserMO>();
}

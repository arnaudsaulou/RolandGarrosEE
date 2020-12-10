package com.cactus.RolandGarrosEE.entities;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PLAYER")
public class Player extends Member {
    @Nullable
    @Column(name="CLASSEMENT", unique = true)
    private int classement;
    @NotNull
    @Column(name="GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany
    private List<Match> matchs;
    @OneToMany
    private List<Team> teams;

    public Player() {
    }

    public Player(String firstname, String lastname, String nationality, int classement) {
        super(firstname, lastname, nationality);
        this.classement = classement;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }
}
